package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val num = StringTokenizer(readln())
    val arr = IntArray(n)

    for (i in 0 until n) {
        arr[i] = num.nextToken().toInt()
    }

    var max = Int.MIN_VALUE

    for (i in 0..n - k) {
        var now = 0
        for (j in 0 until k) {
            now += arr[i + j]
        }
        if (now > max) {
            max = now
        }
    }

    println(max)
}