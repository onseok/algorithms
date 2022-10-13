package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()
    val dp = LongArray(101) { 0 }
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2

    repeat(t) {
        val n = br.readLine().toInt()
        if (n <= 5) {
            bw.write("${dp[n]}\n")
        } else {
            for (i in 6..n) {
                dp[i] = dp[i - 1] + dp[i - 5]
            }
            bw.write("${dp[n]}\n")
        }
    }

    bw.flush()
    bw.close()
}
