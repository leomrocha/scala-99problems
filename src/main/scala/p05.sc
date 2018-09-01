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

object P05 {
  // Again, with builtins this is easy. -> from the site answer
  def reverse[T](ls: List[T]): List[T] = ls.reverse

  def reverse_1[T](l: List[T]): List[T] =  {
    def loop(l: List[T], rl: List[T]): List[T]  = l match {
      case Nil => rl
      case h :: t => loop(t, h :: rl )
    }
    loop(l, Nil)
  }
}
import P05._

val lists = (0 to 10).toList.map( i => (0 to i).toList)

lists.map(i => reverse(i))
lists.map(i => reverse_1(i))
