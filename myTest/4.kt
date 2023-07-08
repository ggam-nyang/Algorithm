package myTest

class Solution4 {
    fun solution(maxSize: Int, actions: Array<String>): Array<String> {
        val explore = Explore()
        actions.forEach { action ->
            explore.action(action)
        }

        return explore.getRecentList(maxSize)
    }

    class Explore {
        var current: String? = null
            private set
        val recentList = linkedSetOf<String>()
        val backList = mutableListOf<String>()
        val frontList = mutableListOf<String>()

        fun getRecentList(maxSize: Int): Array<String> {
            return recentList.toList().takeLast(maxSize).reversed().toTypedArray()
        }

        fun action(action: String) {
            when (action) {
                "B" -> {
                    if (backList.isNotEmpty()) {
                        frontList.add(current!!)
                        val target = backList.removeLast()
                        recentList.remove(target)
                        recentList.add(target)
                    }
                }
                "F" -> {
                    if (frontList.isNotEmpty()) {
                        backList.add(current!!)
                        val target = frontList.removeLast()
                        recentList.remove(target)
                        recentList.add(target)
                    }
                }
                else -> {
                    if (current != null) backList.add(current!!)
                    frontList.clear()
                    current = action
                    recentList.remove(action)
                    recentList.add(action)
                }
            }
        }
    }

    @JvmInline
    value class Stock(val value: Char)

    sealed class Action {
        class Go: Action()
        class Back: Action()
        class Front: Action()
    }
}
