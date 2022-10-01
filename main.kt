fun main() {
    val test = IntArray(4) { it -> it * 1}

    test.forEach {
        println(it)
    }
}