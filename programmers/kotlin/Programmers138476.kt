package programmers.kotlin

class Programmers138476 {
    fun solution(k: Int, tangerine: IntArray): Int {
        val tangerineMap = hashMapOf<Int, Int>()
        tangerine.forEach {
            tangerineMap[it] = tangerineMap.getOrDefault(it, 0) + 1
        }
        val tangerineList = tangerineMap.toList().sortedByDescending { it.second }

        var remainTangerine = k
        var answer: Int = 0
        tangerineList.forEach { (size, cnt) ->
            remainTangerine -= cnt
            answer += 1
            if (remainTangerine <= 0) {
                return answer
            }
        }

        return answer
    }
}