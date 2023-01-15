package baekjoon.smtc

import java.util.*
import kotlin.math.max

fun main() = with(Scanner(System.`in`)) {
    val (N, M, C) = nextLine().split(' ').map(String::toInt)

    val satisfyMap = arrayListOf<IntArray>()
    (1..C).forEach { _ ->
        satisfyMap.add(nextLine().split(' ').map(String::toInt).toIntArray())
    }

    val nPersonalityMap = nextLine().split(' ').map(String::toInt)
    val mPersonalityMap = nextLine().split(' ').map(String::toInt)

    // 인원 n, m에 대한 만족도의 최대값을 기록
    val result = Array(N) { IntArray(M) }

    // n, m == 0 일때 init
    result[0][0] = satisfyMap[nPersonalityMap[0] - 1][mPersonalityMap[0] - 1]
    (1 until M).forEach { m ->
        result[0][m] = max(result[0][m - 1], satisfyMap[nPersonalityMap[0] - 1][mPersonalityMap[m] - 1])
    }
    (1 until N).forEach { n ->
        result[n][0] = max(result[n - 1][0], satisfyMap[nPersonalityMap[n] - 1][mPersonalityMap[0] - 1])
    }

    (1 until N).forEach { n ->
        (1 until M).forEach { m ->
            result[n][m] = max(result[n - 1][m - 1] + satisfyMap[nPersonalityMap[n] - 1][mPersonalityMap[m] - 1],
                max(result[n][m - 1], result[n - 1][m])
            )
        }
    }

    println(result.last().last())
}