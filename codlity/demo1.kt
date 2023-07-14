package codlity

fun solution1(A: IntArray): Int {
    val checked = BooleanArray(A.size + 1)
    checked[0] = true
    A.forEach {
        if(it > 0 && it < checked.size) checked[it] = true
    }

    checked.forEachIndexed { idx, value ->
        if (!value) return idx
    }

    return checked.size
}