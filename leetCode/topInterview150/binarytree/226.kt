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
class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val tempNode = root.left
        root.left = root.right
        root.right = tempNode

        invertTree(root.left)
        invertTree(root.right)

        return root
    }
}