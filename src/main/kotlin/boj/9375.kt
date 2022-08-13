package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val clothesMap = mutableMapOf<String, String>()
        var ans = 0
        val ansList = mutableListOf<Int>()
        val n = br.readLine().toInt()
        for (i in 0 until n) {
            val (a, b) = br.readLine().split(" ")
            clothesMap[b] += "a"
        }
        if (clothesMap.size == 1) {
            ans = clothesMap.values.toString().count() { c -> c == 'a' }
        } else {
            ans = 1
            clothesMap.values.forEach {
                ansList.add(it.count { c -> c == 'a' })
            }
            for (x in ansList) {
                ans *= (x+1)
            }
            ans -= 1
        }
        println(ans)
    }
}
