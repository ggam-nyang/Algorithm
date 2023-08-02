package baekjoon.tony.`1_data_structure2`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.absoluteValue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val pq = PriorityQueue<AbsValue1>()

    for (i in 1 .. N) {
        val input = br.readLine().toInt()

        if (input == 0) {
            if (pq.isEmpty()) bw.write("0")
            else bw.write(pq.poll().value.toString())
            bw.newLine()
        }
        else
            pq.add(AbsValue1(input, input.absoluteValue))
    }
    bw.flush()
    bw.close()
}

data class AbsValue1(
    val value: Int,
    val absValue: Int
) : Comparable<AbsValue1> {
    override fun compareTo(other: AbsValue1): Int {
        return if (this.absValue != other.absValue) this.absValue - other.absValue
        else this.value - other.value
    }
}