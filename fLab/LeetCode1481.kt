package fLab

import java.util.PriorityQueue

class LeetCode1481 {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        // faster by heapify
        val hm = arr.groupBy { it }
            .mapValues { it.value.size }

        var copyK = k
        var leftNum = hm.size

        hm.values
            .sorted()
            .forEach { cnt ->
                if ( cnt <= copyK) {
                    copyK -= cnt
                    leftNum --
                } else return leftNum
            }

        return leftNum
    }
}