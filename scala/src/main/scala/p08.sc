import collection.mutable
/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 07:
  *
  * Eliminate consecutive duplicates of list elements.
  * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
  * Example:
  *
  * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  */

object P08 {
  def compress[T](ls: List[T]): List[T] = ls match {
      case Nil => Nil
      case h :: t => h :: compress( t.dropWhile( _ == h) )
  }

  //that is not tail recursive, so  do it again

  def compress1[T](ls: List[T]): List[T] = {
    def loop(l:List[T], acc:List[T]): List[T] = l match {
      case Nil => acc.reverse
      case h :: t => loop( t.dropWhile( _ == h), h :: acc )
    }

    loop(ls, List())
  }

  def compress2[T](ls: List[T]): List[T] = {

    ls.foldRight(List[T]()){
      (h, acc) => acc match {
//        case Nil => h :: acc
        case ah :: _ if h == ah => acc
        case _ => h :: acc
      }
    }
  }

  //TODO do it with mutable state and for comprehension
//  def compress[T](ls: List[T]): List[T] = {
//    var out = mutable.ListBuffer.empty(T)
//    for {
//
//    }
//
//  }

}
import P08._

compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
compress1(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
