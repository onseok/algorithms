package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 사다리와 뱀은 모두 HashMap으로 관리한다.
// 사다리나 뱀을 타는 것은 주사위 횟수에 포함되지 않는다.

private var map: HashMap<Int, Int>? = null

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    map = hashMapOf() // 사다리와 뱀 정보 map
    for (i in 0 until n) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        map!![from] = to
    }
    for (i in 0 until m) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        map!![from] = to
    }
    println(bfs())
}

private fun bfs(): Int {
    var cnt = 0
    val visited = BooleanArray(101)
    val q: Queue<Int> = LinkedList()
    visited[1] = true
    q.offer(1)
    while (!q.isEmpty()) {
        val size = q.size
        for (i in 0 until size) {
            val cur = q.poll()
            if (cur == 100) return cnt
            for (add in 1..6) {
                var next = cur + add
                if (next > 100) break
                if (visited[next]) continue
                if (map!!.containsKey(next)) {
                    next = map!![next]!!
                    if (visited[next]) continue
                }
                q.offer(next)
                visited[next] = true
            }
        }
        cnt++
    }
    return cnt
}
