package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readln().split(" ")
    val n = input[0].toLong()
    val k = input[1].toLong()
    val m = input[2].toInt()
    val comb = Array(2003) { IntArray(2003) }
    for (i in 0 until m + 1) {
        comb[i][0] = 1
        comb[i][i] = 1
        for (j in 1 until i) {
            comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % m
        }
    }
    var ret = 1
    var N = n
    var K = k
    while (N > 0 || K > 0) {
        ret = (ret * comb[(N % m).toInt()][(K % m).toInt()]) % m
        N /= m
        K /= m
    }
    println(ret)
}