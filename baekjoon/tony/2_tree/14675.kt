package baekjoon.tony.`2_tree`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var graph: Array<ArrayList<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    graph = Array(n + 1) { arrayListOf<Int>() }

    for (i in 0 until n - 1) {
        val token = StringTokenizer(br.readLine())
        val a = token.nextToken().toInt()
        val b = token.nextToken().toInt()

        graph[a].add(b)
        graph[b].add(a)
    }

    val q = br.readLine().toInt()
    for (i in 0 until q) {
        val token = StringTokenizer(br.readLine())
        val a = token.nextToken().toInt()
        val b = token.nextToken().toInt()

        if (a == 1) {
            if (isCutVertex(b)) bw.write("yes")
            else bw.write("no")
        } else {
            bw.write("yes")
        }
        bw.newLine()
    }

    bw.flush()
    bw.close()
}

private fun isCutVertex(vertex: Int) = graph[vertex].size >= 2