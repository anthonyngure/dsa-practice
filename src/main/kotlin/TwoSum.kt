package io.github.anthonyngure

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
fun main() {
    val nums = intArrayOf(10, 15, 3, 7)
    println("twoSumBruteForce(${nums}, 17): ${twoSumBruteForce(nums, 17)}")
    println("twoSumBruteForce(${nums}, 18): ${twoSumBruteForce(nums, 18)}")
    println("twoSumBruteForce(${nums}, 19): ${twoSumBruteForce(nums, 19)}")
    println("twoSumBruteForce(${nums}, 20): ${twoSumBruteForce(nums, 20)}")
    println("------------------------------------------------------------")
    println("twoSumEfficient(${nums}, 17): ${twoSumEfficient(nums, 17)}")
    println("twoSumEfficient(${nums}, 18): ${twoSumEfficient(nums, 18)}")
    println("twoSumEfficient(${nums}, 19): ${twoSumEfficient(nums, 19)}")
    println("twoSumEfficient(${nums}, 20): ${twoSumEfficient(nums, 20)}")
}

/**
 * Time complexity is O(n^2)
 */
private fun twoSumBruteForce(nums: IntArray, target: Int): Boolean {
    for (i in nums.indices){
        for (j in i + 1 until nums.size){
            if (nums[i] + nums[j] == target) return true
        }
    }
    return false
}

/**
 * Use set to track the numbers that have been seen
 * Time complexity will be O(n)
 * Space complexity will be O(n) due to the seen set
 * Empty list or single element list return false
 * Negative numbers work the same
 * Multiple valid pairs, return true as soon as a valid pair is seen
 */
private fun twoSumEfficient(nums: IntArray, target: Int): Boolean {
    if (nums.size < 2) return false // Edge case empty or single element
    // Set to track seen elements
    val seen = mutableSetOf<Int>()
    // Iterate
    for (n in nums){
        if (seen.contains(target - n)) return true
        seen.add(n)
    }
    return false
}