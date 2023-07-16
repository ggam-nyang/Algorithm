package codlity

import java.util.*

private fun solution(K: Int, A: IntArray): Int {
    val n = A.size
    val maxDeque: Deque<Int> = ArrayDeque()
    val minDeque: Deque<Int> = ArrayDeque()

    var left = 0
    var right = 0
    var count = 0

    while (right < n) {
        while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[right]) {
            maxDeque.pollLast()
        }
        while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[right]) {
            minDeque.pollLast()
        }
        maxDeque.offerLast(right)
        minDeque.offerLast(right)

        while (A[maxDeque.peekFirst()] - A[minDeque.peekFirst()] > K) {
            if (minDeque.peekFirst() == left) {
                minDeque.pollFirst()
            }
            if (maxDeque.peekFirst() == left) {
                maxDeque.pollFirst()
            }
            left++
        }
        count += right - left + 1

        if (count > 1_000_000_000) {
            return 1_000_000_000
        }
        right++
    }
    return count
}
