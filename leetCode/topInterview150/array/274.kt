package leetCode.topInterview150.array

class Solution274 {
    fun hIndex(citations: IntArray): Int {
        val sortedCitations = citations.sortedDescending()
        citations
            .withIndex()
            .sortedByDescending {it.value }
            .binarySearch {
                if (it.index + 1 > it.value) -1
                else 1
            }
        sortedCitations.forEachIndexed { index, cit ->
            if (index + 1 > cit) return index
        }

        return citations.size
    }

//    fun hIndex1(citations: IntArray): Int {
//        return citations
//            .withIndex()
//            .sortedByDescending { it.value }
//            .binarySearch {
//                if (it.index + 1 > it.value) 0
//                else -1
//            }
//    }
}