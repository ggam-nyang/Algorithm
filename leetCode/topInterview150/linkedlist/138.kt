package leetCode.topInterview150.linkedlist

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution138 {
    private val cache = hashMapOf<Node, Node>()

    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        return copy(node)
    }

    private fun copy(node: Node?): Node? {
        if (node == null) return null

        if (!cache.contains(node)) {
            val newNode = Node(node.`val`)
            cache[node] = newNode
            newNode.next = copy(node.next)
            newNode.random = copy(node.random)
        }

        return cache[node]!!
    }

    private fun copy2(node: Node?): Node? {
        if (node == null) return null

        if (!cache.contains(node)) {
            cache[node] = Node(node.`val`)
            cache[node]?.apply {
                next = copy2(node.next)
                random = copy2(node.random)
            }
        }

        return cache[node]!!
    }
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}