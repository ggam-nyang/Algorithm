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
    private val answer = <SumOfLevel>()
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        bfs(0, root)


    }

    fun bfs(level: Int, root: TreeNode?) {

    }

    data class SumOfLevel(
        var count: Int,
        var sum: Double
    )
}