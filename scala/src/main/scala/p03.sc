/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 03:
  *
  * Find the find_k but one element of a list.
  * Example:
  * scala> find_k(List(1, 1, 2, 3, 5, 8))
  * res0: Int = 5
  *
  */
object P03 {
  // Again, with builtins this is easy. -> from the site answer
  def find_k[A](ls: List[A], k: Int): A = ls(k)

  // go forward till the find_k element but keep the find_k 2 in a cache
  def find_k_1[T](l: List[T], k: Int): T =  {

    def loop(l: List[T], k:Int, count:Int): T  = {
      if( k == count) l.head
      else loop(l.tail,k, count+1)
    }

    loop(l, k, 0)

  }
}
import P03._

find_k(List(1,2,3,4,5,6,7), 0)
find_k(List(1,2,3,4,5,6,7), 1)
find_k(List(1,2,3,4,5,6,7), 2)
find_k(List(1,2,3,4,5,6,7), 3)
find_k(List(1,2,3,4,5,6,7), 4)
find_k(List(1,2,3,4,5,6,7), 5)
find_k(List(1,2,3,4,5,6,7), 6)
find_k_1(List(1,2,3,4,5,6,7), 0)
find_k_1(List(1,2,3,4,5,6,7), 1)
find_k_1(List(1,2,3,4,5,6,7), 2)
find_k_1(List(1,2,3,4,5,6,7), 3)
find_k_1(List(1,2,3,4,5,6,7), 4)
find_k_1(List(1,2,3,4,5,6,7), 5)
find_k_1(List(1,2,3,4,5,6,7), 6)
