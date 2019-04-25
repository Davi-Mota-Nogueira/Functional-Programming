
fun main(){
    println("Hello World!")
    val l1 = Node(1,Node(2,Node(3,Nil)))
    println(l1)
    val l2 = increment(l1)
    println(l2)
    println(decrement(l2))
    val l3 = selectEven(l2)
    println(l3)
    println(selectOdd(l2))
    val l4 = Node(4,Node(5,Node(72,Node(30,Nil))))
    println(greater10(l4))
    val l5 = Node(1,Node(2,Node(3,Node(4,Nil))))
    println(sum(l5))
    println(multiply(l5))
    println(divide(l5))
}

/*
    Part that defines the Node,
    This is the definition of a almost robust code, is just missing the generics.
    List
 */
abstract class List
object Nil:List()
data class Node(val head:Int,val tail:List):List()
typealias Fint = (Int)->Int // Atalho para não escrever muito

/*

fun increment(l: List):List = if (l is Node)
                                Node(l.head+1,increment(l.tail))
                                else
                                Nil

fun decrement(l: List):List = if(l is Node)
                                Node(l.head-1,decrement(l.tail))
                                else
                                Nil

fun multiplica2(l:List):List = if(l is Node)
                                Node(l.head*2,multiplica2(l.tail))
                                else
                                Nil

 */


fun map(f:Fint,l:List):List = when(l){
    is Node -> Node(f(l.head),map(f,l.tail))
    else -> Nil
}
val decrement = {l:List -> map({x:Int -> x-1},l)}
val increment = {l:List -> map({x:Int -> x+1},l)}
val times2 = {l:List -> map({x:Int -> x*2},l)}


/*

fun selecEven(l:List):List = when{
    l is Node && l.head%2 == 0 -> Node(l.head,selecEven(l.tail))
    l is Node && l.head%2 != 0 -> selecEven(l.tail)
    else -> Nil
}

fun selecOdd(l:List):List = when{
    l is Node && l.head%2 != 0 -> Node(l.head,selecOdd(l.tail))
    l is Node && l.head%2 == 0 -> selecOdd(l.tail)
    else -> Nil
}

fun greater10(l:List):List = when{
    l is Node && l.head > 10 -> Node(l.head,greater10(l.tail))
    l is Node && l.head < 10 -> greater10(l.tail)
    else -> Nil
}

 */

fun filter(f:(Int) -> Boolean,l:List):List = when{
    l is Node && f(l.head) -> Node(l.head,filter(f,l.tail))
    l is Node && !f(l.head) -> filter(f,l.tail)
    else -> Nil
}
val selectEven = {l:List -> filter({x:Int -> x%2==0},l)}
val selectOdd = {l:List -> filter({x:Int -> x%2!=0},l)}
val greater10 = {l:List -> filter({x:Int -> x>10},l)}




fun reduce(f:(Int,Int)->Int,l:List,v0:Int):Int = when(l){
    is Node -> l.head + reduce(f,l.tail,v0)
    else -> v0
}

val sum = {l:List -> reduce({x,y -> x+y },l,0)}
val multiply = {l:List -> reduce({x,y->x*y},l,1)}
val divide = {l:List -> reduce({x,y->x/y},l,1)}










