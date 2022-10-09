import java.util.PriorityQueue

fun main() {
    var test = PriorityQueue<Int>(5)

    test.add(2)
    test.add(1)
    test.add(3)
    test.add(-3)
    test.add(19213)


    println(test)
    test.remove(test.last())
    test.poll()
    test.reversed()


    println(test)
}