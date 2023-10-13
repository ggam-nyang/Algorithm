package leetCode.topInterview150.matrix

class Solution54 {
    private val directions = arrayOf(
        Position(0, 1),
        Position(1, 0),
        Position(0, -1),
        Position(-1, 0)
    )

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val row = matrix.size
        val col = matrix.first().size
        val visited = Array(row) { BooleanArray(col) }
        visited[0][0] = true

        val currPosition = Position(0, 0)
        val answer = mutableListOf<Int>(matrix[currPosition.x][currPosition.y])
        var directionIndex = 0
        while (answer.size < row * col) {
            val newX = currPosition.x + directions[directionIndex].x
            val newY = currPosition.y + directions[directionIndex].y

            if (newX in 0 until row && newY in 0 until col && !visited[newX][newY]) {
                currPosition.x = newX
                currPosition.y = newY
                visited[newX][newY] = true
                answer.add(matrix[currPosition.x][currPosition.y])
            } else {
                directionIndex = (directionIndex + 1) % 4
            }
        }

        return answer
    }

    data class Position(
        var x: Int,
        var y: Int
    )
}