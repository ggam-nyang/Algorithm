package leetCode.topInterview150.linkedlist

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val nodeSet = hashSetOf<ListNode>()
        var currentNode = head

        while (currentNode != null) {
            if (!nodeSet.contains(currentNode)) nodeSet.add(currentNode)
            else return true

            currentNode = currentNode.next
        }

        return false
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}