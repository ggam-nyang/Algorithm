package fLab

class LeetCode938 {
    var sumOfTree = 0

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        traverse(low, high, root)

        return sumOfTree
    }

    // change if block then can reduce traverse line
    private fun traverse(low: Int, high: Int, aNode: TreeNode?) {
        if (aNode == null) return

        if (aNode.`val` < low) traverse(low, high, aNode.right)
        else if (aNode.`val` > high) traverse(low, high, aNode.left)
        else {
            sumOfTree += aNode.`val`
            traverse(low, high, aNode.right)
            traverse(low, high, aNode.left)
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}