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
class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var ln1 = l1
        var ln2 = l2
        val head = ListNode(0)
        var curr = head
        var carry = 0

        while (ln1 != null || ln2 != null || carry != 0) {
            var sum = 0

            ln1?.let {
                sum += it.`val`
                ln1 = it.next
            }

            ln2?.let {
                sum += it.`val`
                ln2 = it.next
            }

            sum += carry
            carry = sum / 10

            curr.next = ListNode(sum % 10)
            curr = curr.next!!
        }

        return head.next
    }
}
