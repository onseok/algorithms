package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private var root = 0
private var ans = 0
private var d = 0
private lateinit var adj: ArrayList<ArrayList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    adj = ArrayList()
    for (i in 0 until n) {
        adj.add(ArrayList())
    }
    val input = readln().split(" ").map { it.toInt() }
    input.forEachIndexed { index, node ->
        if (node != -1) {
            adj[node].add(index)
        } else {
            root = index
        }
    }
    d = readln().toInt()
    if (d != root) {
        deleteNode(root)
        dfs(root)
    }
    println(ans)
}

private fun deleteNode(idx: Int) {
    for (child in adj[idx]) {
        if (child == d) {
            adj[idx].remove(child)
            return
        }
        deleteNode(child)
    }
}

private fun dfs(idx: Int) {
    if (adj[idx].size == 0) {
        ans++
        return
    }
    for (child in adj[idx]) {
        dfs(child)
    }
}



