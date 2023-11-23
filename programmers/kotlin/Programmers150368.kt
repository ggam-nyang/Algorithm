package programmers.kotlin

lateinit var discounts: ArrayList<Int>
lateinit var discountLists: ArrayList<ArrayList<Int>>

class Programmers150368 {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        discountLists = arrayListOf()
        discounts = arrayListOf(10, 20, 30, 40)
        val tempList = arrayListOf<Int>()
        dupCombination(tempList, 0, emoticons.size)

        val discountedEmoticons = discountLists.map { discounts ->
            discounts.mapIndexed { index, discount ->
                emoticons[index] * (100 - discount) / 100
            }
        }

        discountedEmoticons.forEach { dcEmoticons ->
            users.forEach { user ->
                val (dc, maxPrice) = user
                dcEmoticons.forEach { dcEmoticon ->
                    dcEmoticon
                }
            }
        }

        var answer: IntArray = intArrayOf()
        return answer
    }
}

// 중복조합
fun dupCombination(list: ArrayList<Int>, index: Int, count: Int) {
    // 다 뽑았을 때
    if (count == 0) {
        val temp = ArrayList(list)
        discountLists.add(temp)
        return
    }
    for (i in index until discounts.size) {
        list.add(discounts[i])
        dupCombination(list, i, count - 1) // 뽑을 때 마다 count - 1
        list.removeAt(list.size - 1) // 재귀 위해 마지막에 넣은 원소 제거
    }
}