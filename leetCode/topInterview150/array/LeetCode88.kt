package leetCode.topInterview150.array

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val answer = IntArray(m + n)

        var left = 0
        var right = 0

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                answer[left + right] = nums1[left]
                left++
            } else {
                answer[left + right] = nums2[right]
                right++
            }
        }

        while (left < m) {
            answer[left + right] = nums1[left]
            left++
        }
        while (right < n) {
            answer[left + right] = nums2[right]
            right++
        }

        answer.indices.forEach { nums1[it] = answer[it] }
    }

    fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var left = m - 1
        var right = n - 1
        var target = m + n - 1

        while (right >= 0) {
            nums1[target--] = if (left < 0 || nums2[right] >= nums1[left]) nums2[right--] else nums1[left--]
        }
    }
}