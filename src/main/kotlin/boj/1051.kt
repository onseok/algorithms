package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().toCharArray() }
    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            val size = min(m - j, n - i)
            for (k in size downTo 1) {
                if (arr[i][j] == arr[i + k - 1][j + k - 1] &&
                    arr[i][j] == arr[i][j + k - 1] &&
                    arr[i][j] == arr[i + k - 1][j]
                ) {
                    ans = max(k * k, ans)
                }
            }
        }
    }
    println(ans)
}