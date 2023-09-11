package leetCode.topInterview150.matrix

class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        (0 until 9).forEach { idx ->
            if (!rowCheck(idx, board) || !colCheck(idx, board)) return false
        }
        if (!squareCheck(board)) return false

        return true
    }

    private fun rowCheck(idx: Int, board: Array<CharArray>) : Boolean {
        val tempRow = board[idx].filterNot { it == '.' }
        println(tempRow)

        return tempRow.size == tempRow.toSet().size
    }

    private fun colCheck(idx: Int, board: Array<CharArray>): Boolean {
        val tempCol = board.map { it[idx] }.filterNot { it == '.' }

        return tempCol.size == tempCol.toSet().size
    }

    private fun squareCheck(board: Array<CharArray>): Boolean {
        val temp = intArrayOf(0, 3, 6)
        temp.forEach { row ->
            temp.forEach { col ->
                val tempSquare = (row until row + 3).flatMap {r ->
                    (col until col + 3).map {c -> board[r][c] }
                }.filterNot { it == '.' }

                println(tempSquare)
                if (tempSquare.size != tempSquare.toSet().size) return false
            }
        }

        return true
    }
}