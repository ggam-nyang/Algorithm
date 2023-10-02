package leetCode.topInterview150.bst

import leetCode.topInterview150.binarytree.TreeNode
import kotlin.math.min

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
class Solution530 {
    private var diff = Int.MAX_VALUE

    fun getMinimumDifference(root: TreeNode?): Int {
        if (root == null) return 0

        if (root.left != null) {
            diff = min(root.`val`- root.left!!.`val`, diff)
            getMinimumDifference(root.left)
        }

        if (root.right != null) {
            diff = min(root.right!!.`val` - root.`val`, diff)
            getMinimumDifference(root.right)
        }

        return diff
    }
}