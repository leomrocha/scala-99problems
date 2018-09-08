
/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 09:
  *
  * Pack consecutive duplicates of list elements into sublists.
  * If a list contains repeated elements they should be placed in separate sublists.
  * Example:
  *
  * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  */

object P09 {
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

  //solution from the site
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

}
import P09._

groupEquals(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//groupEquals2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
