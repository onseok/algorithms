package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val x = LongArray(n + 1)
    val y = LongArray(n + 1)

    var sumA = 0L
    var sumB = 0L

    repeat(n) { idx ->
        val (a, b) = readLine().split(" ").map { it.toLong() }
        x[idx] = a
        y[idx] = b
    }

    x[n] = x[0]
    y[n] = y[0]

    for (i in 0 until n) {
        sumA += x[i] * y[i + 1]
        sumB += x[i + 1] * y[i]
    }

    println(String.format("%.1f", abs(sumA - sumB) / 2.0))
}