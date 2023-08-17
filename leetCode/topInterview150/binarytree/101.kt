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
class Solution101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        if (isMirror(root.left, root.right)) return true

        return false
    }

    private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left?.`val` != right?.`val`) return false
        if (isMirror(left?.right, right?.left) && isMirror(left?.left, right?.right)) return true

        return false
    }
}