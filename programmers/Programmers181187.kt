package programmers

import kotlin.math.max
import kotlin.math.min

class Programmers181187 {
    fun solution(r1: Int, r2: Int): Long {
        val large = max(r1, r2)
        val small = min(r1, r2)

        var quarterCnt = 0L
        (1 .. large). forEach { x ->
            (1 .. large).forEach { y ->
                if (x * x + y * y in small * small .. large * large) quarterCnt++
            }
        }

        return quarterCnt * 4 + (large - small) * 4
    }
}