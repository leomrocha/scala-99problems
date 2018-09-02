/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 05:
  *
  * Reverse a list.
  * Example:
  * scala> reverse(List(1, 1, 2, 3, 5, 8))
  * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  */

object P06 {
  def palindrome[T](ls: List[T]): Boolean = ls.reverse == ls
  //I've already implemented reverse so that's it

}
import P06._


palindrome("palindrome".toList)
palindrome("12345678987654321".toList)


