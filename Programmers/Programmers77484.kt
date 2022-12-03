package Programmers

import kotlin.math.abs
import kotlin.math.sqrt

class Programmers77484 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val maxNum = lottos.filterNot { it == 0 }
            .count { win_nums.contains(it) } + lottos.count { it == 0 }

        val minNum = lottos.filterNot { it == 0 }
            .count { win_nums.contains(it) }

        return intArrayOf(convertToLottoRank(maxNum), convertToLottoRank(minNum))
    }

    fun convertToLottoRank(correctCnt: Int): Int {
        val answer = 7 -correctCnt

        return if (answer > 6) 6 else answer
    }
}
