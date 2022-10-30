package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    if (n < 100) {
        println(n / 10 + n % 10)
    } else if (n % 10 == 0) {
        println(n / 100 + 10)
    } else {
        println(n % 100 + 10)
    }
}