package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val graph = Array(10) { IntArray(10) }
    for (i in 0 until 10) {
        val line = readln().toCharArray()
        for (j in 0 until 10) {
            if (line[j] == 'O') {
                graph[i][j] = 1
            } else if (line[j] == '#') {
                graph[i][j] = 0
            }
        }
    }

    repeat(1024) {

    }
}