import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var pq: PriorityQueue<Node>
private lateinit var parents: Array<Int>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    pq = PriorityQueue()
    val (v, e) = readLine().split(" ").map { it.toInt() }
    parents = Array(v + 1) { i -> i } // 부모는 나 자신으로 초기화

    repeat(e) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        pq.offer(Node(a, b, c)) // 큐에 다 넣기
    }

    println(solve())
}

fun solve(): Int {
    var sum = 0 // 가중치 누적 합 계산
    while (!pq.isEmpty()) {
        val node = pq.poll()
        // start, end의 부모 찾기
        val parentS = find(node.start)
        val parentE = find(node.end)
        // 부모가 다르다면  (연결되어있지 않다면)
        if (parentS != parentE) {
            union(parentS, parentE) // 둘을 연결
            sum += node.weight // 가중치 계산
        }
    }
    return sum
}

fun union(a: Int, b: Int) {
    val A = find(a)
    val B = find(b)
    if (A == B) return
    parents[B] = A
}

fun find(x: Int): Int {
    if (parents[x] == x) return x
    parents[x] = find(parents[x])
    return parents[x]
}

private data class Node(val start: Int, val end: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(n: Node): Int { // 가중치 기준 오름차순 정렬
        return weight - n.weight
    }
}