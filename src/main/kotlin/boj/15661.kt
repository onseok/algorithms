package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

private var n: Int = 0
private var arr: Array<IntArray> = emptyArray()
private val visited: BooleanArray = BooleanArray(20)
private var ans: Int = 987654321

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    arr = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            arr[i][j] = line[j]
        }
    }
    combination(0)
    println(ans)
}

fun calculate(): Int {
    var cnt1 = 0
    var cnt2 = 0
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            if (visited[i] && visited[j]) {
                cnt1 += arr[i][j] + arr[j][i]
            } else if (!visited[i] && !visited[j]) {
                cnt2 += arr[i][j] + arr[j][i]
            }
        }
    }
    return abs(cnt1 - cnt2)
}

// 조합 알고리즘
fun combination(cnt: Int) {
    if (cnt == n) {
        ans = min(ans, calculate())
        return
    }
    visited[cnt] = true
    combination(cnt + 1)
    visited[cnt] = false
    combination(cnt + 1)
}