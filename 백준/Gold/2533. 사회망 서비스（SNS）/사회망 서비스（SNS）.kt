import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private lateinit var visited: BooleanArray
private lateinit var dp: Array<IntArray>
private lateinit var adj: Array<ArrayList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    // dp -> 해당 지점까지의 얼리어답터 인원수
    dp = Array(n + 1) { IntArray(2) }
    visited = BooleanArray(n + 1)
    adj = Array(n + 1) { ArrayList() }

    for (i in 0 until n - 1) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        adj[u].add(v)
        adj[v].add(u)
    }
    dfs(1) // 트리 구조이기 때문에 1부터 시작한다
    println(min(dp[1][0], dp[1][1]))
}

private fun dfs(num: Int) {
    visited[num] = true
    dp[num][0] = 0 // 해당 num이 얼리어답터가 아닌 경우
    dp[num][1] = 1 // 해당 num이 얼리어답터인 경우 (우선 시작 시 해당 지점 얼리어답터이므로 개수 1)

    for (child in adj[num]) {
        if(!visited[child]) {
            dfs(child) // dfs 재귀호출을 통해 자식 노드의 dp값을 미리 구한다.
            dp[num][0] += dp[child][1] // 자식 노드가 무조건 얼리어답터여야 한다.
            dp[num][1] += min(dp[child][0], dp[child][1]) // 자식노드가 무조건 얼리어답터일 필요는 없지만 최소한의 얼리어답터 인원을 뽑기 때문에
        }
    }
}