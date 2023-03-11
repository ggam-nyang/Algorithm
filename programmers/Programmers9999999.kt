package programmers

class Programmers9999999 {
    fun solution(word: String): Int {
        val alphaMap = hashMapOf<Char, Int>()
        val idxMap = hashMapOf<Int, Int>()

        alphaMap.putAll(arrayOf('A' to 0, 'E' to 1, 'I' to 2, 'O' to 3, 'U' to 4))
        idxMap.putAll(arrayOf(0 to 781, 1 to 156, 2 to 31, 3 to 6, 4 to 1))
        var answer = 0
        word.forEachIndexed { idx, c ->
            answer += idxMap[idx]!! * alphaMap[c]!! + 1
        }

        return answer
    }
}