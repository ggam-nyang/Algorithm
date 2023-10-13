package leetCode.topInterview150.slidingwindow

import kotlin.math.max

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var hm = hashMapOf<Char, Int>()

        var answer = 0
        s.withIndex().forEach { (i, c) ->
            if (hm.contains(c)) {
                answer = max(answer, hm.size)
                hm = hm.filter { it.value > hm[c]!! } as HashMap<Char, Int>
            }
            hm[c] = i
        }
        answer = max(answer, hm.size)

        return answer
    }

    // LinkedHashMap을 사용하면 시간 복잡도, 공간 복잡도를 훨씬 낮출 수 있다.
}