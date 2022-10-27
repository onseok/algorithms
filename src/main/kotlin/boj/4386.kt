package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * @author onseok
 */

data class Star(var start: Int, var end: Int, var weight: Double) : Comparable<Star> {
    override fun compareTo(other: Star): Int {
        val result = (weight - other.weight).toInt()
        return if ((weight - other.weight).toInt() == 0) {
            if (weight - other.weight > 0) {
                1
            } else if (weight - other.weight < 0) {
                -1
            } else {
                0
            }
        } else result
    }
}

data class Coordinate(var x: Double, var y: Double)

private lateinit var parents: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    parents = IntArray(n + 1) { i -> i }

    val starInfo = ArrayList<Pair<Int, Coordinate>>()

    for (i in 1..n) {
        val (x, y) = readLine().split(" ").map { it.toDouble() }
        starInfo.add(Pair(i, Coordinate(x, y)))
    }

    val pq = PriorityQueue<Star>()

    for (i in 0 until starInfo.size - 1) {
        for (j in i + 1 until starInfo.size) {
            pq.add(Star(starInfo[i].first, starInfo[j].first, distance(starInfo[i].second, starInfo[j].second)))
        }
    }

    var ans = 0.0
    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (find(cur.start) != find(cur.end)) {
            union(cur.start, cur.end)
            ans += cur.weight
        }
    }

    println(ans)

}

fun distance(a: Coordinate, b: Coordinate): Double {
    return sqrt(abs(a.x - b.x).pow(2) + abs(a.y - b.y).pow(2))
}

private fun union(a: Int, b: Int) {
    val aParent = find(a)
    val bParent = find(b)

    parents[bParent] = aParent
}

private fun find(x: Int): Int {
    if (parents[x] != x) parents[x] = find(parents[x])
    return parents[x]
}

