package com.tispunshahryar960103.test

fun main() {

    //fibonacci(10)
   // println( factorial(5))
    productTable(5)


}

/**
 * Product Table
 */

fun productTable(num:Int){


    for (i in 1..num){
        for (j in 1..num){

            print(" ${i*j} ")

        }
        println()
    }
}


/**
 * Prime Nimbers
 */
fun printPrimeNumbers(num: Int) {

    val numList= mutableListOf<Int>()

    if (num <= 1) {
        println("Please Enter a number greater than 1")
    } else {
        for (i in 2 .. num) {
           for (j in 2 until i){
               if (i % j != 0){
                   numList.add(i)
               }
           }
        }
    }

    println("the count of prime numbers in 1 until $num is : ${numList.size} ")
}


/**
 * Fibonacci Series
 */

fun fibonacci(num: Int) {

    var a = 0
    var b = 1
    var c: Int
    println(a)
    println(b)

    for (i in 1..num) {
        c = a + b
        println(c)
        a = b
        b = c
    }

}

/**
 * Factorial
 */

fun factorial(num: Long): Long {
    var facto: Long = num

    when (num) {
        0L -> println("The factorial of $num is : 1")
        1L -> println("Please enter a number bigger than ONE!")
        else -> {


            for (i in 2 until num) {


                facto *= i

            }


        }
    }

    return facto


}





