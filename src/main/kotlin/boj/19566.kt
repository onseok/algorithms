package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readln().split(" ")
    val n = input[0].toInt()
    val k = input[1].toLong()
    val arr = readln().split(" ").map { it.toLong() }

    val prefixSum = LongArray(n + 1) { i -> if (i == 0) 0 else arr[i - 1] }
    var result = 0L
    val map = mutableMapOf<Long, Long>()
    for (i in 1 until n + 1) {
        prefixSum[i] += prefixSum[i - 1]
        val calc = prefixSum[i] - k * i

        result += map.getOrDefault(calc, 0L)
        map[calc] = map.getOrDefault(calc, 0L) + 1
    }
    println(result + map.getOrDefault(0, 0))
}