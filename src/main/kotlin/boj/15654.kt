package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
val input = br.readLine().split(" ").map { it.toInt() }
var list = br.readLine().split(" ").map { it.toInt() }
private val n = input[0]
val m = input[1]
val ans = IntArray(n)
val isVisited = BooleanArray(n) { false }

fun main() = with(br) {
    list = list.sortedBy { it }
    backTracking(0)
    bw.flush()
    bw.close()
}

fun backTracking(depth: Int) {
    if (depth == m) {
        for (i in 0 until m) {
            bw.write("${ans[i]} ")
        }
        bw.write("\n")
        return
    }
    for (i in 0 until list.size) {
        if (isVisited[i]) {
            continue
        }
        isVisited[i] = true
        ans[depth] = list[i]
        backTracking(depth + 1)
        isVisited[i] = false
    }
}