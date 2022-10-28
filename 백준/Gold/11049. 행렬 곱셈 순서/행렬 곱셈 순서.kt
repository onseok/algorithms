import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private lateinit var data: IntArray
private lateinit var dp: Array<IntArray>
private const val INF = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    data = IntArray(n + 1)
    for (i in 0 until n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        data[i] = a
        data[i + 1] = b
    }

    dp = Array(n) { IntArray(n) { INF } }
    println(solve(0, n - 1))
}

private fun solve(pos: Int, cur: Int): Int {
    if (pos == cur) return 0
    if (dp[pos][cur] != INF) return dp[pos][cur]

    for (i in pos until cur) {
        val value = solve(pos, i) +
                solve(i + 1, cur) +
                (data[pos] * data[i + 1] * data[cur + 1])
        dp[pos][cur] = min(dp[pos][cur], value)
    }

    return dp[pos][cur]
}