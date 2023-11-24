package programmers.kotlin

class Programmers150370 {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val termMap = terms.associate {
            val temp = it.split(" ")
            temp.first() to temp.last().toInt()
        }

        val temp = privacies.map {
            val (date, term) = it.split(" ")
            isValid(today, date, termMap[term]!!)
        }

        return temp
            .withIndex()
            .filter { !it.value }
            .map { it.index + 1 }
            .toIntArray()
    }

    private fun isValid(today: String, date: String, term: Int): Boolean {
        val todayDate = Date from today
        val targetDate = Date from date

        var monthDiff = 0
        if (todayDate.year != targetDate.year) {
            monthDiff += (todayDate.year - targetDate.year) * 12
        }
        if (todayDate.month != targetDate.month) {
            monthDiff += (todayDate.month - targetDate.month)
        }

        if (monthDiff == term) return todayDate.day - targetDate.day < 0
        return monthDiff < term
    }

    data class Date(
        val year: Int,
        val month: Int,
        val day: Int,
    ) {
        companion object {
            infix fun from(string: String): Date {
                val temp = string.split(".")
                return Date(temp[0].toInt(), temp[1].toInt(), temp[2].toInt())
            }
        }
    }
}