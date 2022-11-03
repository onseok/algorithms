package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

private lateinit var adj: ArrayList<ArrayList<Nodee>>
private lateinit var dist: IntArray
private lateinit var check: BooleanArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    val m = readln().toInt()
    adj = ArrayList() // 인접 리스트
    for (i in 0..n) {
        adj.add(ArrayList())
    }
    dist = IntArray(n + 1) { Int.MAX_VALUE } // 시작점에서 각 정점으로 가는 최단거리
    check = BooleanArray(n + 1) // 방문 확인

    for (i in 0 until m) {
        val (start, end, weight) = readln().split(" ").map { it.toInt() }
        adj[start].add(Nodee(end, weight))
    }

    val (startPos, endPos) = readln().split(" ").map { it.toInt() }
    println(dijkstra(startPos, endPos))
}

private fun dijkstra(start: Int, end: Int): Int {
    val pq: PriorityQueue<Nodee> = PriorityQueue()
    pq.offer(Nodee(start, 0))
    dist[start] = 0

    while (pq.isNotEmpty()) {
        val curNode = pq.poll()
        val cur = curNode.end

        if (!check[cur]) {
            check[cur] = true

            for (node in adj[cur]) {
                if(!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight
                    pq.add(Nodee(node.end, dist[node.end]))
                }
            }
        }
    }
    return dist[end]
}

data class Nodee(val end: Int, val weight: Int) : Comparable<Nodee> {
    override fun compareTo(other: Nodee): Int {
        return weight - other.weight
    }
}
