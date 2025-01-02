package io.github.anthonyngure

/**
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
fun main() {
    val data = intArrayOf(1, 2, 3, 4)
    println("bruteForce(${data.joinToString(",")}): ${bruteForce(data).joinToString(",")}")
    println("optimized(${data.joinToString(",")}): ${optimized(data).joinToString(",")}")
}

/**
 * Time Complexity will be O(n^2)
 */
private fun bruteForce(data: IntArray): IntArray {
    var result = IntArray(data.size) // Init with size
    for (i in data.indices) { // Traversal
        var product = 1
        for (j in data.indices) {
            if (i != j) { // Skip the current element
                product *= data[j]
            }
        }
        result[i] = product // Insertion
    }
    return result
}

/**
 * Edge cases
 * - Is array empty
 * - Is there more than 1 zero
 */
private fun optimized(data: IntArray): IntArray {

    if (data.isEmpty()) return intArrayOf()

    val n = data.size

    val result = IntArray(data.size)

    // Compute prefix products
    result[0] = 1
    for (i in 1 until n) {
        result[i] = result[i - 1] * data[i - 1]
    }

    // Compute suffix products and multiply with prefix products
    var suffixProduct = 1
    for (i in n - 1 downTo 0) {
        result[i] *= suffixProduct
        suffixProduct *= data[i]
    }

    return result
}