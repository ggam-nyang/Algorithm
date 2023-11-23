package programmers.kotlin

class Programmers12915 {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings
            .sortedWith(
                comparator = compareBy<String> { it[n] }
                    .thenBy { it }
            )
            .toTypedArray()
    }
}
