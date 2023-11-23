package programmers.kotlin

class ProgrammersWhatNum {
    fun solution(topping: IntArray): Int {
        val leftSet = hashSetOf<Int>()
        val rightMap = topping
            .groupBy { it }
            .mapValues { it.value.size }
            .toMutableMap()
        var rightCnt = rightMap.size

        var answer = 0
        topping.forEach { aTopping ->
            leftSet.add(aTopping)
            rightMap[aTopping] = rightMap[aTopping]!! - 1
            if (rightMap[aTopping] == 0) rightCnt--
            if (leftSet.size == rightCnt) answer++
        }

        return answer
    }
}