package leetCode.topInterview150.binarytree

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
class Solution222 {
    private var count = 0
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        count++
        countNodes(root.left)
        countNodes(root.right)

        return count
    }
}