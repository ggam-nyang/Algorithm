package programmers.kotlin

import kotlin.math.sqrt

class Programmers_92335 {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        val primeCandidates = n.toString(k).split("0")
        primeCandidates.forEach {
            if (isPrime(it.toLongOrNull() ?: 1)) answer++
        }

        return answer
    }

    private fun isPrime(n: Long): Boolean {
        if (n == 1L) return false

        for (i in 2 ..sqrt(n.toDouble()).toInt()) {
            if (n % i == 0L) return false
        }

        return true
    }
}