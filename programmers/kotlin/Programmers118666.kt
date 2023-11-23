package programmers.kotlin

class Programmers118666 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val characterMap = Character.values().associateWith { 0 }.toMutableMap()

        choices.indices.forEach {idx ->
            val left = Character from survey[idx].first()
            val right = Character from survey[idx].last()
            calculateScore(characterMap, left, right, choices[idx])
        }

        return getResult(characterMap)
    }

    private fun getResult(characterMap: MutableMap<Character, Int>): String {
        var answer = ""

        if (characterMap[Character.R]!! >= characterMap[Character.T]!!) answer += Character.R.char
        else answer += Character.T
        if (characterMap[Character.C]!! >= characterMap[Character.F]!!) answer += Character.C.char
        else answer += Character.F
        if (characterMap[Character.J]!! >= characterMap[Character.M]!!) answer += Character.J.char
        else answer += Character.M
        if (characterMap[Character.A]!! >= characterMap[Character.N]!!) answer += Character.A.char
        else answer += Character.N

        return answer
    }

    private fun calculateScore(characterMap: MutableMap<Character, Int>, left: Character, right: Character, choice: Int) {
        when (choice) {
            1, 2, 3 -> characterMap[left] = characterMap[left]!! + (4 - choice)
            5, 6, 7 -> characterMap[right] = characterMap[right]!! + (choice - 4)
        }
    }

    enum class Character(val char: Char) {
        R('R'),
        T('T'),
        C('C'),
        F('F'),
        J('J'),
        M('M'),
        A('A'),
        N('N');

        companion object {
            infix fun from(char: Char): Character = Character.values().firstOrNull { it.char == char } ?: throw IllegalArgumentException()
        }
    }
}