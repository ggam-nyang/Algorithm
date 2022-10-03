package devMatching

class Solution2 {
    fun solution(maps: Array<String>): Int {
        val R = maps.size
        val C = maps.first().length

        val result = hashMapOf<Char, Int>()
        val checked = Array(R) { Array(C) { 0 } }

        maps.forEachIndexed { r, row ->
            row.forEachIndexed { c, str ->
                if (checked[r][c] == 0 && str != '.') {
                    checked[r][c] = 1
                    bfs(maps, checked, r, c).forEach { k, v ->
                        result[k] = result.getOrPut(k) { 0 } + v
                    }
                }
            }
        }

        return result.maxOf { it.value }
    }

    private val xDirection = arrayListOf(0, 0, -1, 1)
    private val yDirection = arrayListOf(-1, 1, 0, 0)


    fun bfs(maps: Array<String>, checked: Array<Array<Int>>, row: Int, col: Int): HashMap<Char, Int> {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addFirst(Pair(row, col))

        val alphMap = hashMapOf<Char, Int>()

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            val alph = maps[r][c]
            alphMap[alph] = alphMap.getOrPut(alph) { 0 } + 1

            (0..3).forEach { i ->
                val newRow = r + xDirection[i]
                val newCol = c + yDirection[i]

                if (newRow < 0 || newRow >= checked.size || newCol < 0 || newCol >= checked.first().size)
                    return@forEach

                if (checked[newRow][newCol] == 0 && maps[newRow][newCol] != '.') {
                    checked[newRow][newCol] = 1
                    queue.addLast(Pair(newRow, newCol))
                }
            }
        }


        val winner = alphMap.entries
            .sortedWith(compareByDescending<MutableMap.MutableEntry<Char, Int>> { it.value }.thenByDescending { it.key})
            .first().key

        val totalArea = alphMap.map { it.value }
            .filter { it < alphMap[winner]!! }
            .sum()

        alphMap.forEach { k, v ->
            if (v < alphMap[winner]!!) alphMap[k] = 0
        }

        alphMap[winner] = alphMap[winner]!! + totalArea

        return alphMap
    }
}