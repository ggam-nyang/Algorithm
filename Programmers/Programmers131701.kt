package Programmers

class Programmers131701 {
    fun solution(elements: IntArray): Int {
        val sumSet = hashSetOf<Int>()

        val newElements = elements + elements
        elements.forEachIndexed { i, firstValue ->
            var num = firstValue
            sumSet.add(num)
            (i + 1 until i + elements.size).forEachIndexed { j, nextValue ->
                num += newElements[nextValue]
                sumSet.add(num)
            }
        }

        return sumSet.size
    }
}