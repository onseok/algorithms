package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val siteMap = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val (site, password) = br.readLine().split(" ")
        siteMap[site] = password
    }
    for (i in 0 until m) {
        val searchSite = br.readLine()
        println(siteMap[searchSite])
    }
}