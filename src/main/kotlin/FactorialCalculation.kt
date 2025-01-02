package io.github.anthonyngure

fun main() {
    val n = 25
    println("factorialRecursive($n) = ${factorialRecursive(n)}")
    println("factorialIterative($n) = ${factorialIterative(n)}")
}

private fun factorialIterative(n: Int): Long {
    var result = 1L
    for (i in 1..n){
        result = result * i
    }
    return result
}

private fun factorialRecursive(n: Int): Long {
    if (n == 0) return 1
    return n * factorialRecursive(n - 1)
}