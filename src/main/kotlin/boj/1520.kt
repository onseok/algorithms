package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)
private var m = 0
private var n = 0
private lateinit var arr: Array<IntArray>
private lateinit var dp: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line = readln().split(" ").map { it.toInt() }
    m = line[0]
    n = line[1]
    arr = Array(m) { IntArray(n) }
    repeat(m) { idx ->
        val input = readln().split(" ").map { it.toInt() }.toIntArray()
        arr[idx] = input
    }

    dp = Array(m) { IntArray(n) { -1 } }
    println(dfs(0, 0))
}

private fun dfs(x: Int, y: Int): Int {
    if (x == m - 1 && y == n - 1) {
        return 1
    }
    if (dp[x][y] != -1) {
        return dp[x][y]
    }

    dp[x][y] = 0 // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화.
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1) {
            continue
        }
        // arr[x][y]보다 arr[dx][dy]가 높이가 더 낮다면
        // arr[dx][dy]에서 끝점까지 도달하는 경로의 개수를 더한다.
        if (arr[x][y] > arr[nx][ny]) {
            dp[x][y] += dfs(nx, ny)
        }
    }
    return dp[x][y]
}