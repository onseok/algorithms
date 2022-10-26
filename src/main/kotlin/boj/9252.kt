package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val first = readln()
    val second = readln()
    val lcs = Array(first.length + 1) { IntArray(second.length + 1) }
    val ans = LinkedList<Char>()
    for (i in 1..first.length) {
        for (j in 1..second.length) {
            if (first[i - 1] == second[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
            }
        }
    }
    var max = lcs[first.length][second.length]
    for (i in first.length downTo 1) {
        for (j in second.length downTo  1) {
            if (first[i - 1] == second[j - 1] && lcs[i][j] == max) {
                max--
                ans.addLast(first[i - 1])
                break
            }
        }
    }

    val sb = StringBuilder()
    while (ans.isNotEmpty()) {
        sb.append(ans.pollLast())
    }
    println(lcs[first.length][second.length])
    println(sb)
}