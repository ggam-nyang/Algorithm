class Solution12914 {
    private val memo = hashMapOf<Int, Long>()

    fun solution(n: Int): Long {
        if (n == 1) return 1
        if (n == 2) return 2

        val answer = memo.getOrPut(n - 1){ solution(n - 1) } + memo.getOrPut(n - 2) { solution(n - 2) }
        return answer % 1234567
    }
}