import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * @author onseok
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val adj = ArrayList<ArrayList<Int>>()
    for (i in 0..n + 1) {
        adj.add(ArrayList())
    }
    val deg = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        deg[b]++
    }

    val q: Queue<Int> = LinkedList()

    for (i in 1..n) {
        if (deg[i] == 0) q.offer(i)
    }

    while (!q.isEmpty()) {
        val cur = q.poll()
        bw.write("$cur ")
        val list: List<Int> = adj[cur]
        for (i in list.indices) {
            val nxt = list[i]
            deg[nxt]--
            if (deg[nxt] == 0) q.offer(nxt)
        }
    }

    close()
    bw.flush()
    bw.close()

}