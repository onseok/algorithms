package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val INF = 1_000 * 1_000
    val n = readLine().toInt()
    val arr: Array<Array<Int>> = Array(n + 1) {
        Array(3) { INF }
    }
    val dp: Array<Array<Int>> = Array(n + 1) {
        Array(3) { INF }
    }
    var ans = INF

    for (i in 1..n) {
        val (r, g, b) = readLine().split(" ").map { it.toInt() }
        arr[i][0] = r
        arr[i][1] = g
        arr[i][2] = b
    }

    for (k in 0 until 3) {
        for (i in 0 until 3) {
            if (i == k) {
                dp[1][i] = arr[1][i]
            } else {
                dp[1][i] = INF
            }
        }

        for (i in 2..n) {
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0]
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1]
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2]
        }

        for (i in 0 until 3) {
            if (i != k) {
                ans = min(ans, dp[n][i])
            }
        }
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}