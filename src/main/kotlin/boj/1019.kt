package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var ans: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readln().toInt()
    ans = IntArray(10)
    var point = 1
    var start = 1
    while (start <= n) {
        while (n % 10 != 9 && start <= n) {
            calc(n, point)
            n--
        }
        if (n < start) break

        while (start % 10 != 0 && start <= n) {
            calc(start, point)
            start++
        }
        start /= 10
        n /= 10

        for (i in 0 until 10) {
            ans[i] += (n - start + 1) * point
        }
        point *= 10
    }
    println(ans.joinToString(" "))
}

private fun calc(x: Int, point: Int) {
    var X = x
    while (X > 0) {
        ans[X % 10] += point
        X /= 10
    }
}