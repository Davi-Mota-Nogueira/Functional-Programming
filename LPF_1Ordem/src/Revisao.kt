fun maior(f:Fint, g:Fint:Fint = {x -> if(f(x)>g(x))
    f(x)
else
    g(x)}



fun potencia(f:Fint, i:Int):Fint =
    {x -> when{
        i == 0 -> 1
        i == 1 -> f(x)
        else -> f(potencia(f,i-1))
    }}

fun encadear(f:Fint,g:Fint):Fint=
        {x -> f(g(x))}


fun numerosRepetidos(l:List):Int {
    fun aux(l:List, i:Int):Int = when{
        l is Node -> if(l.tail is Node){
            if (l.i == l.tail.i){
                aux(l.tail,i+1)
            }
            else{
                aux(l.tail,i)
            }
        }
        else -> i
    }
    return aux(l,0)
}

fun mergeSort(l:List):List{
    fun aux (l1:List,l2:List):List = when{
        l1 is Node && l2 is Node ->
            if(l1.size == 1 && l2.size == 1){
                if (l1.head > l2.head){
                    Node(l2,l1)
                }else
                    Node(l1,l2)
            }else
                Node(mergeSort(l1),mergeSort(l2))
        l1 is Node && l2 is Nil -> l1
        l1 is Nil && l2 is Node -> l2
        else -> Nil
    }
        if (l is Node){
            val l1 = primeiraMetade(l,l.size/2)
            val l2 = segundaMetade(l,l.size/2)
        }else
            Nil
    }
    return aux(l1,l2)
}

fun primeiraMetade(l:List, i:Int):List =
        if (l is Node){
            if (i <= l.size){
                Node(l,primeiraMetade(l.tail,i))
            }else
                Nil
        }else
            Nil

fun segundaMetade(l:List, i:Int):List =
        if (l is Node){
            if (i > l.size)
                Node(l,segundaMetade(l.tail,i))
            else
                Nil
        }else
            Nil

fun run(){
    println("Hello")
}