import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    repeat(t) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val time = readLine().split(" ").map { it.toInt() }
        val adj = ArrayList<ArrayList<Int>>()
        for (i in 0 until n + 1) {
            adj.add(ArrayList())
        }
        val deg = IntArray(n + 1) { 0 }
        repeat(k) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            adj[a].add(b)
            deg[b]++
        }
        val w = readLine().toInt()
        
        val q: Queue<Int> = LinkedList()
        val result = IntArray(n + 1)
        
        for (i in 1..n) {
            if (deg[i] == 0) {
                result[i] = time[i - 1]
                q.offer(i)
            }
        }

        while (!q.isEmpty()) {
            val cur = q.poll()
            val list: List<Int> = adj[cur]
            for (i in list.indices) {
                val nxt = list[i]
                result[nxt] = max(result[nxt], result[cur] + time[nxt - 1])
                deg[nxt]--
                if (deg[nxt] == 0) q.offer(nxt)
            }
        }
        
        println(result[w])
    }
}