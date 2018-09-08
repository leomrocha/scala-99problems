
/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 10:
  *
  * Run-length encoding of a list.
  * Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  * Example:
  *
  * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  */

object P10 {

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

  def countAllEquals[T](ls: List[T]): List[(Int, T)] = {
   for {
     l:List[T] <- groupEquals(ls)
   }yield (l.size, l.head)
  }

  //solution from the site
  def encode[A](ls: List[A]): List[(Int, A)] = groupEquals(ls) map { e => (e.length, e.head) }
}
import P10._

countAllEquals(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
