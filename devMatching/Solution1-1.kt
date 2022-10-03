package devMatching

class `Solution1-1` {
    fun solution(registered_list: Array<String>, new_id: String): String {
        val group = registered_list.groupBy {
            splitId(it).first
        }
            .mapValues {
                it.value.map { splitId(it).second.toIntOrNull() ?: 0 }
            }


        return check(group, new_id)
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

    private fun check(group: Map<String, List<Int>>, id: String): String {
        val (S, N) = splitId(id)
        val n = N.toIntOrNull() ?: 0

        if (group[S]?.contains(n) != true) return id

        return check(group, S + (n + 1).toString())
    }
}