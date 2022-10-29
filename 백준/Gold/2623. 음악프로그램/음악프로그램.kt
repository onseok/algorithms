import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = ArrayList<ArrayList<Int>>()
    val deg = IntArray(n + 1) // 진입차수 배열
    for (i in 0..n) {
        graph.add(ArrayList())
    }
    repeat(m) {
        val seq = readln().split(" ").map { it.toInt() }
        val cnt = seq[0]
        var x = seq[1]
        for (i in 1 until cnt) {
            graph[x].add(seq[i + 1])
            deg[seq[i + 1]]++
            x = seq[i + 1]
        }
    }

    val q: Queue<Int> = LinkedList()

    for (i in 1..n) {
        if (deg[i] == 0) q.offer(i)
    }

    var ans = ArrayList<Int>()

    while (q.isNotEmpty()) {
        val cur = q.poll()
        ans.add(cur)
        for (nxt in graph[cur]) {
            deg[nxt]--
            if (deg[nxt] == 0) q.offer(nxt)
        }
    }
    val sb = StringBuilder()
    if(ans.size != n) println(0)
    else {
        ans.forEach {
            sb.append("$it\n")
        }
        println(sb.toString())
    }
}