/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 01:
  *
  * Find the penultimate but one element of a list.
  * Example:
  * scala> penultimate(List(1, 1, 2, 3, 5, 8))
  * res0: Int = 5
  *
  */
object P02 {
  // Again, with builtins this is easy. -> from the site answer
  def penultimateBuiltin[A](ls: List[A]): A =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

  // go forward till the penultimate element but keep the penultimate 2 in a cache
  def penultimate_1[T](l: List[T]): T = l match {
    case _ :: p :: _ :: Nil => p
    case _ :: t :: u => penultimate_1(t :: u)
    case _ => throw  new NoSuchElementException
  }

  // count the number of elements and return the penultimate on a get
  def penultimate_2a[T](l: List[T]): T =  l(l.length - 2)  //this is unsafe, should do with pattern matching
  def penultimate_2b[T](l: List[T]): T =  l.length match{
    case x if x>=2 => l(l.length - 2)
    case _ => throw  new NoSuchElementException
  }

  // reverse and go to the second element
  def penultimate_3a[T](l: List[T]): T =  l.reverse(1)  //this is unsafe, should do with pattern matching
  def penultimate_3b[T](l: List[T]): T =  l.length match{
    case x if x>=2 => l.reverse(1)
    case _ => throw  new NoSuchElementException
  }

}
import P02._

//penultimateBuiltin(List()) //NoSuchElementException()
//penultimate_1(List())
//penultimate_2a(List())
//penultimate_2b(List())
//penultimate_3a(List())
//penultimate_3b(List())


penultimateBuiltin(List(1,2,3,4,5,6,7))
penultimate_1(List(1,2,3,4,5,6,7))
penultimate_2a(List(1,2,3,4,5,6,7))
penultimate_2b(List(1,2,3,4,5,6,7))
penultimate_3a(List(1,2,3,4,5,6,7))
penultimate_3b(List(1,2,3,4,5,6,7))
