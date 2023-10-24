package leetCode.topInterview150.stack

class MinStack() {
    private val stack = mutableListOf<Int>()
    private var minValue = Int.MAX_VALUE

    fun push(`val`: Int) {
        stack.add(`val`)
        if (`val` < minValue) minValue = `val`
    }

    fun pop() {
        if (stack.isEmpty()) return

        val pop = stack.removeLast()
        if (stack.isEmpty()) {
            minValue = Int.MAX_VALUE
            return
        }
        if (pop == minValue) minValue = stack.min()
    }

    fun top(): Int {
        if (stack.isEmpty()) throw IllegalArgumentException()

        return stack.last()
    }

    fun getMin(): Int {
        return minValue
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */