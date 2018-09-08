
/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 11:
  *
  * Modified run-length encoding.
  * Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
  * Example:
  *
  * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  */

object P11 {

  //from p09
  def groupEquals[T](ls: List[T]): List[List[T]] =  {

      //first case, group one element
      def groupWhileEqual(ls: List[T], acc: List[T], k:T): List[T] = ls match {
        case Nil => acc
        case h :: t if h == k => groupWhileEqual(t, h :: acc, k)
        case _ => acc
      }

    def groupAll(ls: List[T], acc:List[List[T]]): List[List[T]] = ls match {
      case Nil => acc.reverse
      case h :: t =>  groupAll(t.dropWhile(_ == h), groupWhileEqual(ls, List(), h) :: acc)
    }

    groupAll(ls, List())
  }

  def countAllEqualsModif[T](ls: List[T]) = {

    def countAllEquals(ls:List[T]) = {
      for {
        l: List[T] <- groupEquals(ls)
      } yield (l.size, l.head)
    }
    countAllEquals(ls).map( x => x match {
      case (c, k) if c > 1 => (c,k)
      case (_, k) => k
    })
  }

  //solutions from the site
//  def encodeModified[A](ls: List[A]): List[Any] =
//    groupEquals(ls) map { t => if (t._1 == 1) t._2 else t }
//
//  // Just for fun, here's a more typesafe version.
//  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] =
//    groupEquals(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }
}
import P11._

countAllEqualsModif(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//encodeModified2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
