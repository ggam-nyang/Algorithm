package leetCode.topInterview150.divide

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
class Solution108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return getNode(nums, 0, nums.lastIndex)
    }

    private fun getNode(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val mid = (left + right) / 2
        val head = TreeNode(nums[mid])
        head.left = getNode(nums, left, mid - 1)
        head.right = getNode(nums, mid + 1, right)

        return head
    }
}