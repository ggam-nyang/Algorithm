package leetCode.topInterview150.bfs

import leetCode.topInterview150.binarytree.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution637 {
    private val answer = mutableListOf<SumOfLevel>()
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) return doubleArrayOf()

        answer.add(SumOfLevel(1, root.`val`.toLong()))
        bfs(1, root.left)
        bfs(1, root.right)

        return answer.map {
            String.format("%.5f", it.sum.toDouble() / it.count).toDouble()
        }.toDoubleArray()

    }

    fun bfs(level: Int, root: TreeNode?) {
        if (root == null) return

        if (answer.size <= level) answer.add(SumOfLevel(1, root.`val`.toLong()))
        else answer[level].plus(root)

        bfs(level + 1, root.left)
        bfs(level + 1, root.right)
    }

    data class SumOfLevel(
        var count: Int,
        var sum: Long,
    ) {
        fun plus(treeNode: TreeNode) {
            this.count++
            this.sum += treeNode.`val`
        }
    }
}