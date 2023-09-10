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
class Solution112 {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return traversal(root, 0, targetSum)
    }

    private fun traversal(root: TreeNode?, currSum: Int, targetSum: Int): Boolean {
        if (root == null) return false

        val newSum = currSum + root.`val`
        if (newSum == targetSum && root.left == null && root.right == null) return true
        if (traversal(root.left, newSum, targetSum) || traversal(root.right, newSum, targetSum)) return true

        return false
    }
}