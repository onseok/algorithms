import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

lateinit var parent: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    parent = IntArray(n + 1) { i -> i }

    val posX = ArrayList<Pair<Int, Int>>()
    val posY = ArrayList<Pair<Int, Int>>()
    val posZ = ArrayList<Pair<Int, Int>>()

    for (i in 1..n) {
        val (x, y, z) = readLine().split(" ").map { it.toInt() }
        posX.add(Pair(i, x))
        posY.add(Pair(i, y))
        posZ.add(Pair(i, z))
    }

    val sortedX = posX.sortedBy { it.second }
    val sortedY = posY.sortedBy { it.second }
    val sortedZ = posZ.sortedBy { it.second }

    val pq = PriorityQueue<Node>()
    for (i in 0 until n - 1) {
        pq.add(Node(sortedX[i].first, sortedX[i+1].first, sortedX[i+1].second - sortedX[i].second))
        pq.add(Node(sortedY[i].first, sortedY[i+1].first, sortedY[i+1].second - sortedY[i].second))
        pq.add(Node(sortedZ[i].first, sortedZ[i+1].first, sortedZ[i+1].second - sortedZ[i].second))
    }

    var ans = 0L
    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (find(cur.start) != find(cur.end)) {
            union(cur.start, cur.end)
            ans += cur.weight
        }
    }

    println(ans)
}

private fun union(a: Int, b: Int) {
    val aParent = find(a)
    val bParent = find(b)

    parent[bParent] = aParent
}

private fun find(x: Int): Int {
    if (parent[x] != x) parent[x] = find(parent[x])
    return parent[x]
}

data class Node(val start: Int, val end: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}