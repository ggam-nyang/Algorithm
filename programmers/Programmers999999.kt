package programmers

class Programmers999999 {
    fun solution(storey: Int): Int {
        var answer: Int = 0

        val storeyStr = storey.toString()
        storeyStr.forEach {
            if (it != '0') answer += getCount(it)
        }

        if (storey >= 10 && storeyStr.first().digitToInt() > 5) answer -= 1

        return answer
    }

    fun getCount(storey: Char): Int {
        val layer =storey.digitToInt()

        if (layer <= 5) return layer
        return 11 - layer
    }
}