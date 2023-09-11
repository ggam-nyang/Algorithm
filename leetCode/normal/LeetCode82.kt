package leetCode.normal//package LeetCode
//
///**
// * Example:
// * var li = ListNode(5)
// * var v = li.`val`
// * Definition for singly-linked list.
// * class ListNode(var `val`: Int) {
// *     var next: ListNode? = null
// * }
// */
//class LeetCode82 {
//    fun deleteDuplicates(head: ListNode?): ListNode? {
//        var aNode = head
//        val nodeArray = arrayListOf<ListNode>()
//
//        while (aNode?.next != null) {
//            if (aNode.`val` != aNode.next?.`val`) {
//                nodeArray.add(aNode)
//            }
//        }
//        for (i in 0 until nodeArray.size - 1) {
//            nodeArray[i].next = nodeArray[i + 1]
//        }
//
//        return nodeArray.first()
//    }
//}