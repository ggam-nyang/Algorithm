package programmers

class Programmers77486 {
    class Seller(
        val name: String
    ) {
        var parent: Seller? = null
        var result = 0
    }

    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val temp = hashMapOf<String, Int>()
        seller.reversed()
            .forEachIndexed { idx, sel ->
                temp[sel] = temp.getOrPut(sel) { 0 } + amount[idx]

            }

        var answer: IntArray = intArrayOf()
        return answer
    }
}
