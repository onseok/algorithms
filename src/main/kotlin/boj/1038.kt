package boj

import java.io.BufferedReader
import java.io.InputStreamReader

// https://blog.encrypted.gg/142
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = ArrayList<Long>()

    for (i in 1 .. 1023) {
        var num = 0L
        var tmp = i
        for (j in 9 downTo 0) {
            if(tmp % 2 == 1) num = 10 * num + j
            tmp /= 2
        }
        arr.add(num)
    }

    arr.sort()

    val n = readln().toInt()

    if (n > 1022) println("-1")
    else println(arr[n])
}