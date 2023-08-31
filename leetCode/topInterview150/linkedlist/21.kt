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
class Solution21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val head = ListNode(0)
        var left = list1
        var right = list2

        if (left == null) return right
        if (right == null) return left

        var curr: ListNode = head
        while (left != null || right != null) {
            println("left: ${left?.`val`}  right: ${right?.`val`}  curr: ${curr.`val`}")
            if (left!!.`val` <= right!!.`val`) {
                curr.next = left
                curr = curr.next!!
                left = left.next
                if (left == null) {
                    curr.next = right
                    return head.next
                }
            } else {
                curr.next = right
                curr = curr.next!!
                right = right.next
                if (right == null) {
                    curr.next = left
                    return head.next
                }
            }
        }

        return head.next
    }
}