class Programmers131701 {
    fun solution(elements: IntArray): Int {
        val sumSet = hashSetOf<Int>()
        elements.forEachIndexed { i, firstValue ->
            var num = firstValue
            sumSet.add(num)
            (i + 1 until elements.size).forEachIndexed { j, nextValue ->
                println("$i    $nextValue")
                num += elements[nextValue]
                sumSet.add(num)
            }
        }

        return sumSet.size
    }
}