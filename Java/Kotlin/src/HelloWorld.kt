fun main(args: Array<String>) {
    test()
    //println(Sum(1, 2))
    //println("foo is " + foo())
}

public fun Sum(a: Int, b: Int): Int {
    return a + b;
}

fun test() {
    println("----test----")
    arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach {
        if (it == 2) {
            println("in 2")
            return@forEach
        } else {
            println(it)
        }
    }
    println("----end----")
}

fun foo(): Int {
    a@ for (i in 1..10) {
        b@ for (j in 1..10) {
            if (j == 5) break@b
            if (i == 5) break@a
            println("i=$i,j=$j")
        }
    }
    //println("forEach is " + value0)
    /* var value = a@ arrayOf(0, 1, 2, 3).forEach lit@{
         if (it == 0) return@a 1
         println("forEach on " + it)
         return@lit
     }
     println("forEach is " + value)*/
    return 1
}