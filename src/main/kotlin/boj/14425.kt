package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val trie = Trie<Char>()
    var ans = 0
    repeat(n) {
        trie.insert(readLine())
    }
    repeat(m) {
        if (trie.contains(readLine())) ans++
    }
    println(ans)
}

