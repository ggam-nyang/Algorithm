package programmers.kotlin

class Programmers64062 {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        var tempStones = stones.map { it - (stones.minOrNull() ?: 0) }.toIntArray()
        answer += stones.minOrNull() ?: 0
        while (isPossible(tempStones, k)) {
            answer ++
            tempStones = tempStones.map { it - 1 }.toIntArray()
        }

        return answer
    }

    private fun isPossible(stones: IntArray, k: Int) : Boolean {
        main@ for (st in 0 .. stones.size - k) {
            for (i in 0 until k) {
                if (stones[st + i] > 0) continue@main
            }

            return false
        }

        return true
    }
}