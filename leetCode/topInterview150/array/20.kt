package leetCode.topInterview150.array

class Solution20 {
    fun isValid(s: String): Boolean {
        val checkMap = hashMapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        val stack = arrayListOf<Char>()
        s.forEach { c ->
            when (c) {
                '(' -> stack.add(c)
                '{' -> stack.add(c)
                '[' -> stack.add(c)
                else -> {
                    if (stack.isEmpty() || stack.removeAt(stack.lastIndex) != checkMap[c]) return false
                }
            }
        }
        if (stack.isNotEmpty()) return false

        return true
    }
}