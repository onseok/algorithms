package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        var ans = -1
        val (m, n, x, y) = br.readLine().split(" ").map { it.toInt() }
        for (i in x .. (n*m) step m) {
            if ((i - y) % n == 0) {
                ans = i
                break
            }
        }
        println(ans)
    }
}

