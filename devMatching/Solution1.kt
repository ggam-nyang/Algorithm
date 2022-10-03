package devMatching

class Solution1 {
    fun solution(registered_list: Array<String>, new_id: String): String {
        if (!registered_list.contains(new_id)) return new_id


        val (S, N) = splitId(new_id)
        val n = if (N == "") 0 else N.toInt()

        return solution(registered_list, S + (n + 1).toString())
    }

    private fun splitId(id: String) : Pair<String, String> {
        var result: Int?

        var s: String = ""
        var n: String = ""

        id.forEach { c ->
            result = c.digitToIntOrNull()
            if (result != null) n += result
            else s += c
        }

        return Pair(s, n)
    }
}