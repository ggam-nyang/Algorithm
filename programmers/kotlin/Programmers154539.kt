package programmers.kotlin

class Programmers154539 {
    fun solution(numbers: IntArray): IntArray {
        val stack = arrayListOf<Int>()

        val answer = IntArray(numbers.size)
        numbers.indices.reversed().forEach { idx ->
            while (stack.isNotEmpty()) {
                val top = stack.last()

                if (numbers[idx] < top) {
                    answer[idx] = top
                    break
                }
                stack.removeLast()
            }
            if (stack.isEmpty()) answer[idx] = -1
            stack.add(numbers[idx])
        }

        return answer
    }
}