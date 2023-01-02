package programmers

class Programmers134239 {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val points = getPoints(k)

        return ranges.map { range ->
            getWidth(range, points)
        }.toDoubleArray()
    }

    private fun getWidth(range: IntArray, points: ArrayList<Int>): Double {
        val start = range.first()
        val end = points.size + range.last() - 1

        if (start > end) return -1.0
        if (start == end) return 0.0

        return (start..end).sumOf { points[it].toDouble() } - (points[start] + points[end]).toDouble() / 2

    }

    private fun getPoints(k: Int): ArrayList<Int> {
        val answer = arrayListOf<Int>()

        var kk = k
        while (kk > 1) {
            answer.add(kk)
            if (kk % 2 == 0) kk /= 2
            else kk = kk * 3 + 1
        }
        answer.add(kk)

        return answer
    }
}
