/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 07:
  *
  * Flatten a nested list structure.
  * Example:
  * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  */

object P07 {
  def flatten[T](ls: List[List[T]]): List[T] = ls.flatten

  def flatten1[T](ls: List[Any]): List[Any] = ls flatMap {
     case x:List[_] => flatten1(x)
     case e => List(e)
    }

}
import P07._

val lists = (0 to 10).toList.map( i => (0 to i).toList)

//lists.map(i => flatten(i))
lists.map(i => flatten1(i))
