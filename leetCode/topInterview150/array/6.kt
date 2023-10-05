package leetCode.topInterview150.array

class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val answer = StringBuilder()

        val head = addHead(s, numRows)
        val tail = addTail(s, numRows)

        answer.append(head)
        (1 until numRows - 1).forEach { row ->
            var idx = 1

            while (idx * numRows - idx - (numRows - 1 - row) < s.length) {
                val inner = idx * numRows - idx - (numRows - 1 - row)
                val outer = idx * numRows - idx + (numRows - 1 - row)
                answer.append(s[inner])

                if (outer >= s.length) break
                answer.append(s[outer])

                idx += 2
            }
        }
        answer.append(tail)

        return answer.toString()
    }

    private fun addHead(s: String, numRows: Int): StringBuilder {
        var pos = 0
        val answer = StringBuilder()

        while (pos < s.length) {
            answer.append(s[pos])
            pos += 2 * numRows - 2
        }

        return answer
    }

    private fun addTail(s: String, numRows: Int): StringBuilder {
        var pos = numRows - 1
        val answer = StringBuilder()

        while (pos < s.length) {
            answer.append(s[pos])
            pos += 2 * numRows - 2
        }

        return answer
    }
}