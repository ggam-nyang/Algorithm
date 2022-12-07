package programmers

fun solution87389(n: Int): Int {
    var answer: Int = 2
    while (true) {
        if ((n - 1) % answer == 0) break
        else answer++
    }

    return answer
}