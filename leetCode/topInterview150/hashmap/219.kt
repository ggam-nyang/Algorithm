package leetCode.topInterview150.hashmap

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, num ->
            if (map.contains(num)) {
                if (index - map[num]!! <= k) return true
            }
            map[num] = index
        }

        return false
    }
}