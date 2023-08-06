package leetCode.topInterview150.array

class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        val tempList = arrayListOf<Int>()

        nums.forEachIndexed { i, num ->
            if (num != `val`) {
                tempList.add(num)
                k++
            }
        }

        tempList.indices.forEach {
            nums[it] = tempList[it]
        }

        return k
    }

    fun removeElementBeautiful(nums: IntArray, num: Int): Int {
        var counter = 0
        nums.forEach {
            if (it != num) {
                nums[counter] = it
                counter++
            }
        }

        return counter
    }
}