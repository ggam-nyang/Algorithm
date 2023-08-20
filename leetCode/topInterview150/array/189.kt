package leetCode.topInterview150.array

class Solution189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        val rotateCnt = k % nums.size
        val copyNums = nums.copyOf()

        if (rotateCnt == 0) return

        nums.indices.forEach { idx ->
            val index = (idx - rotateCnt + nums.size) % nums.size
            nums[idx] = copyNums[index]
        }
    }

    fun rotate1(nums: IntArray, k: Int): Unit {
        val rotateCnt = k % nums.size
        var startIndex = 0
        var currentIndex = 0
        var prev = nums[currentIndex]
        var temp: Int
        var newIndex: Int

        nums.indices.forEach { _ ->
            newIndex = (currentIndex + rotateCnt) % nums.size

            temp = nums[newIndex]
            nums[newIndex] = prev
            prev = temp
            currentIndex = newIndex

            if (newIndex == startIndex) {
                startIndex = (startIndex + 1) % nums.size
                currentIndex = startIndex
                prev = nums[startIndex]
            }
        }
    }
}