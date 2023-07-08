package myTest

class Solution2 {
    private lateinit var relationMap: Map<Int, ArrayList<Int>>
    private lateinit var visited: BooleanArray
    private var farFriends = mutableSetOf<Int>()

    fun solution(relationships: Array<IntArray>, target: Int, limit: Int): Int {
        relationMap = initRelationMap(relationships)
        visited = BooleanArray(relationMap.size + 1)

        val nearFriend = relationMap[target]?.size ?: throw IllegalArgumentException()
        visited[target] = true
        dfs(target, 0, limit)

        return calculateReward(nearFriend)
    }

    private fun calculateReward(nearFriend: Int) = nearFriend * 5 + farFriends.size * 10 + farFriends.size

    private fun initRelationMap(relationships: Array<IntArray>): HashMap<Int, ArrayList<Int>> {
        val map = hashMapOf<Int, ArrayList<Int>>()
        relationships.forEach { relationship ->
            val (p1, p2) = relationship
            map.getOrPut(p1) { arrayListOf() }.add(p2)
            map.getOrPut(p2) { arrayListOf() }.add(p1)
        }
        return map
    }

    private fun dfs(target: Int, level: Int, limit: Int) {
        if (level > limit) return
        if (level > 1) farFriends.add(target)

        relationMap[target]?.forEach { friend ->
            if (!visited[friend]) {
                visited[friend] = true
                dfs(friend, level + 1, limit)
                visited[friend] = false
            }
        }
    }
}