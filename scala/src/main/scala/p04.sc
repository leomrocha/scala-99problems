/**
  * Problems from http://aperiodic.net/phil/scala/s-99/
  *
  * Problem 04:
  *
  * Find the number of elements of a list.
  * Example:
  * scala> length(List(1, 1, 2, 3, 5, 8))
  * res0: Int = V6
  *
  */
object P04 {
  // Tgain, with builtins this is easy. -> from the site answer
  def find_length[T](ls: List[T]): Int = ls.length
  def find_length_1[T](ls: List[T]): Int = ls.size

  def find_length_2[T](l: List[T]): Int =  {
    def loop(l: List[T], count:Int): Int  = l match {
      case Nil => count
      case _ :: t => loop(t, count+1)
    }
    loop(l, 0)
  }


//def find_length_3[T](l: List[T]): Int = l.reduce((acc, _ ) => acc + 1)
def find_length_4[T](l: List[T]): Int = l.foldLeft(0)( (acc, _ ) => acc + 1)

}
import P04._

//TODO find a way to do this, I need to correctly understand the types
val f_list: List[_ => Int] = List(find_length _, find_length_1 _, find_length_2 _ )
val lists = (0 to 10).toList.map( i => (0 to i).toList)
//TODO find a way to do this, I need to correctly understand the types
//lists.map( l => f_list.map(x => x(l)) )
//f_list.map( _ => f_list.map(x => _(x)) )

lists.map(i => find_length(i))
lists.map(i => find_length_1(i))
lists.map(i => find_length_2(i))
//lists.map(i => find_length_3(i))
lists.map(i => find_length_4(i))
