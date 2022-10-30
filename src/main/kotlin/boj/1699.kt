package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    val dp = IntArray(100_001)
    for (i in 1 until n + 1) {
        dp[i] = i
        for (j in 1 until i) {
            if (j * j > i) break
            if (dp[i] > dp[i - j * j] + 1) {
                dp[i] = dp[i - j * j] + 1
            }
        }
    }
    println(dp[n])
}
