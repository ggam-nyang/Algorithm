package baekjoon

import java.util.*

private var N: Int = 0
private var K: Int = 0
private val dx = intArrayOf(0, 0, -1, 1)
private val dy = intArrayOf(1, -1, 0, 0)
private val graph = arrayListOf<IntArray>()
private val pieceInfos = arrayListOf<PieceInfo>()
private lateinit var pieceMap: Array<Array<ArrayDeque<PieceInfo>>>

fun main() = with(Scanner(System.`in`)) {
    val NK = nextLine().split(' ').map(String::toInt)
    N = NK[0]
    K = NK[1]

    (1.. N).forEach { _ ->
        graph.add(nextLine().split(' ').map(String::toInt).toIntArray())
    }

    pieceMap = Array(N) { Array(N) { ArrayDeque<PieceInfo>() } }
    (1..K).forEach{ num ->
        nextLine().split(' ').map(String::toInt)
            .let {
                val currPiece = PieceInfo(it[0] - 1, it[1] - 1, it[2] - 1, num)
                pieceInfos.add(currPiece)
                pieceMap[currPiece.row][currPiece.column].addLast(currPiece)
            }
    }

    var answer = 0

    while(answer < 1000) {
        moveAllPieces()
//        printGraph()
        answer++
        if (checkPieces()) {
            println(answer)
            return
        }
    }

    println(-1)
}

fun printGraph() {
    pieceMap.forEach { r ->
        r.forEach { c ->
            c.forEach { piece ->
                print("${piece.row} ${piece.column} ${piece.direct} ")
            }
            print("   ")
        }
        println()
    }
}

fun moveAllPieces() {
    pieceInfos.forEach { pieceInfo ->
        movePiece(pieceInfo)
    }
}

fun movePiece(pieceInfo: PieceInfo, again: Boolean = false) {
//    println(pieceInfo)
    val (r, c, direct) = pieceInfo
    if (pieceMap[r][c].first != pieceInfo) return
    val (nr, nc) = intArrayOf(r + dx[direct], c + dy[direct])

    if (nr in 0 until N && nc in 0 until N) {
        if (graph[nr][nc] == 0) {
            pieceMap[r][c].forEach {
                it.row = nr
                it.column = nc
            }
            pieceMap[nr][nc].addAll(pieceMap[r][c])
            pieceMap[r][c].clear()
        } else if (graph[nr][nc] == 1) {
            pieceMap[r][c].forEach {
                it.row = nr
                it.column = nc
            }
            pieceMap[nr][nc].addAll(pieceMap[r][c].reversed())
            pieceMap[r][c].clear()
        } else {
            pieceInfo.direct = (pieceInfo.direct * 3 + 1) % 4
            if (again) return
            movePiece(pieceInfo, true)
        }
    } else {
        pieceInfo.direct = (pieceInfo.direct * 3 + 1) % 4
        if (again) return
        movePiece(pieceInfo, true)
    }
}

fun checkPieces(): Boolean {
    pieceMap.forEach { r ->
        r.forEach { c ->
            if (c.size >= 4) {
                return true
            }
        }
    }

    return false
}

data class PieceInfo(
    var row: Int,
    var column: Int,
    var direct: Int,
    val num: Int
)
