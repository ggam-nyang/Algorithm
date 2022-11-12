package LeetCode

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        combination(answer, nums.toList(), Array(nums.size) {false}, 0, 3)

        return answer.filter {
            it[0] + it[1] + it[2] == 0
        }.map { it.sorted() }
            .distinct()
    }

    fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
        if(target == 0) {
            answer.addAll( listOf(el.filterIndexed { index, t -> ck[index] }) )
        } else {
            for(i in start until el.size) {
                ck[i] = true
                combination(answer, el, ck, i + 1, target - 1)
                ck[i] = false
            }
        }
    }
}