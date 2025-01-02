package io.github.anthonyngure

fun main() {
    val n = 45
    println("fibonacciIterative($n) = ${fibonacciIterative(n)}")
    println("fibonacciRecursive($n) = ${fibonacciRecursive(n)}")
}

private fun fibonacciIterative(n: Int): Int {
    if (n <= 1) return n
    var a = 0
    var b = 1
    var c = 0
    for (i in 2..n) {
        c = a + b
        a = b
        b = c
    }
    return c
}

private fun fibonacciRecursive(n: Int): Int {
    if (n <= 1) return n // Base case
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2) // Recursive case
}