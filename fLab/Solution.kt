package fLab

class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
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