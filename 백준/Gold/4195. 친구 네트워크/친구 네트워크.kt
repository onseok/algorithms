import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/**
 * @author onseok
 */

private lateinit var parent: IntArray // 유니온 파인드 루트 노드 배열
private lateinit var level: IntArray // 각 노드마다 층의 개수
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readln().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val f = readln().toInt()
        parent = IntArray(f * 2)
        level = IntArray(f * 2)
        for (i in 0 until f * 2) {
            parent[i] = i
            level[i] = 1
        }

        var idx = 0
        val map = HashMap<String, Int>()
        repeat(f) {
            val (a, b) = readln().split(" ")
            if (!map.containsKey(a)) {
                map[a] = idx++
            }

            if (!map.containsKey(b)) {
                map[b] = idx++
            }

            sb.append(union(map.getOrDefault(a, 0), map.getOrDefault(b, 0))).append("\n")
        }
    }
    print(sb.toString())
}

private fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

private fun union(a: Int, b: Int): Int {
    val parentA = find(a)
    val parentB = find(b)

    // 항상 parentA < parentB인 값이 들어온다고 가정
    if (parentA != parentB) {
        parent[parentB] = parentA
        level[parentA] += level[parentB] // parentB에 있던 층의 개수를 더해줌.

        // 어차피 parentB의 부모는 항상 parentA이므로 level[parentB]에 접근할 일은 없으므로
        level[parentB] = 1
    }

    return level[parentA]
}