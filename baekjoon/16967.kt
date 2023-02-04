package baekjoon

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val (H, W, X, Y) = nextLine().split(" ").map(String::toInt)

    val arrayA = Array(H) { IntArray(W) }
    val arrayB = (0 until H + X).map {
        nextLine().split(" ").map(String::toInt).toIntArray()
    }

    (0 until H).forEach { x ->
        (0 until W).forEach { y ->
            arrayA[x][y] = arrayB[x][y]
        }
    }

    (X until H).forEach { x ->
        (Y until W).forEach { y ->
            arrayA[x][y] = arrayB[x][y] - arrayA[x -X][y -Y]
        }
    }

    (0 until arrayA.size - 1).forEach { idx ->
        arrayA[idx].forEach {
            print("$it ")
        }
        println()
    }
    arrayA.last().forEach {
        print("$it ")
    }
}