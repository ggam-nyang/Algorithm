package programmers

import java.lang.Exception

class Programmers77485 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): ArrayList<Int> {
        val square =  Array(rows) { Array(columns) { 0 } }
        (0 until rows).forEach {row ->
            (0 until columns).forEach { col ->
                square[row][col] = row * columns + col + 1
            }
        }
        val answer = arrayListOf<Int>()

        queries.forEach {
            answer.add(rotate(square, it))
        }

        return answer
    }

    private fun rotate(sq: Array<Array<Int>>, query: IntArray) : Int {
        var answer = 0
        val rotatingNumbers = ArrayDeque<Int>()
        val (x1, y1, x2, y2) = query.map { it - 1 }

        for (col in y1 + 1 .. y2) {
            rotatingNumbers.add(sq[x1][col])
        }

        for (row in x1 + 1 .. x2) {
            rotatingNumbers.add(sq[row][y2])
        }

        for (col in y2 - 1 downTo  y1) {
            rotatingNumbers.add(sq[x2][col])
        }

        for (row in x2 - 1 downTo x1) {
            rotatingNumbers.add(sq[row][y1])
        }

        answer = rotatingNumbers.minOrNull() ?: throw Exception()
        rotatingNumbers.addFirst(rotatingNumbers.removeLast())
        var index = 0

        for (col in y1 + 1 .. y2) {
            sq[x1][col] = rotatingNumbers[index++]
        }

        for (row in x1 + 1 .. x2) {
            sq[row][y2] = rotatingNumbers[index++]
        }

        for (col in y2 - 1 downTo  y1) {
            sq[x2][col] = rotatingNumbers[index++]
        }

        for (row in x2 - 1 downTo x1) {
            sq[row][y1] = rotatingNumbers[index++]
        }

        return answer
    }
}
