
/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 12:
  *
  * Decode a run-length encoded list.
  * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
  * Example:
  *
  * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  */

object P12 {

  //from p09
  def decode[T](ls: List[(Int, T)]): List[T] = {

    ls.flatMap(x => x match {
      case (c, k) => (1 to c).map(_ => k)
      case _ => List()

    })
  }
  // From the site -> does not compile
//  def decode1[A](ls: List[(Int, A)]): List[A] = ls flatMap { e => List.make(e._1, e._2) }
}
import P12._

decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
