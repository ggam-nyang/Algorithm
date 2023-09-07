package leetCode.topInterview150.array

import kotlin.math.min

class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        var currIdx = strs.first().lastIndex

        strs.forEach out@ { str ->
            val minIdx = min(currIdx, str.lastIndex)
            (0 .. minIdx).forEach { idx ->
                if (str[idx] != strs.first()[idx]) {
                    currIdx = idx - 1
                    return@out
                }
            }
            currIdx = minIdx
        }
        if (currIdx == -1) return ""

        return strs.first().slice(0 .. currIdx)
    }
}