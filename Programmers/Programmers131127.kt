package Programmers

class Programmers131127 {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer = 0

        val wantMap = want.mapIndexed { index, w ->
            w to number[index]
        }.toMap().toMutableMap()

        for (i in 0 until 10) {
            if (wantMap.containsKey(discount[i]))
                wantMap[discount[i]] = wantMap[discount[i]]!! - 1
        }

        if (discount.size == 10) {
            if (isPossible(wantMap)) return 1
            return 0
        }

        if (isPossible(wantMap)) answer++

        for (i in 10 until discount.size) {
            if (wantMap.containsKey(discount[i]))
                wantMap[discount[i]] = wantMap[discount[i]]!! - 1

            if (wantMap.containsKey(discount[i - 10]))
                wantMap[discount[i - 10]] = wantMap[discount[i - 10]]!! + 1

            if (isPossible(wantMap)) answer++
        }

        return answer
    }

    private fun isPossible(wantMap: MutableMap<String, Int>) : Boolean {
        return wantMap.all { it.value <= 0 }
    }
}
