
import java.util.NoSuchElementException
/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 01:
  *
  * Find the last element of a list.
  * Example:
  * scala> last(List(1, 1, 2, 3, 5, 8))
  * res0: Int = 8
  */
object P01 {
  /**
    * Solution idea 0:
    * use the List API to get the last element
    * tail and other methods usually have an optimized implementation, might be O(1) in some cases
    */

  def last_0a[T](l: List[T]): T = l.last

  def last_0b[T](l: List[T]): T = l.reverse.head

  def last_0c[T](l: List[T]): T = l(l.length-1)

  /**
    * Solution idea 1:
    * O(n) -> go through all the items and return the last
    *
    * @param a
    * @return
    */

  def olast_1[T](l: List[T]): Option[T] = l match {
    case h :: Nil => Some(h)
    case _ :: tail => olast_1(tail)
    case _ => None
  }

  def last_1[T](l: List[T]): T = l match {
    case h :: Nil => h
    case _ :: tail => last_1(tail)
    case _ => throw new NoSuchElementException()
  }
}


import P01._

//last_0a(List()) //NoSuchElementException()
//last_0b(List()) //NoSuchElementException()
//last_0c(List()) //NoSuchElementException()
olast_1(List())
//last_1(List()) //NoSuchElementException()


last_0a(List(1,2,3,4,5,6,7))
last_0b(List(1,2,3,4,5,6,7))
last_0c(List(1,2,3,4,5,6,7))
olast_1(List(1,2,3,4,5,6,7))
last_1 (List(1,2,3,4,5,6,7))
