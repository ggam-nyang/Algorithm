package fLab

class LeetCode1306 {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val visited = BooleanArray(arr.size)

        val queue = ArrayDeque<Int>()
        queue.addLast(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val nowIdx = queue.removeFirst()
            val nowVal = arr[nowIdx]

            if (nowVal == 0) return true

            val left = nowIdx - arr[nowIdx]
            val right = nowIdx + arr[nowIdx]

            if (left >= 0 && !visited[left]) {
                queue.addLast(left)
                visited[left] = true
            }

            if (right < arr.size && !visited[right]) {
                queue.addLast(right)
                visited[right] = true
            }
        }

        return false
    }
}
