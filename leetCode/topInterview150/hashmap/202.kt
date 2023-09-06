package leetCode.topInterview150.hashmap

class Solution202 {
    private val map = hashSetOf<Int>()

    fun isHappy(n: Int): Boolean {
        if (n == 1) return true

        val newNumber = n.toString().sumOf { c ->
            c.digitToInt() * c.digitToInt()
        }
        if (map.contains(newNumber)) return false
        map.add(newNumber)
        return isHappy(newNumber)
    }
}