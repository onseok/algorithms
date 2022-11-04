import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)
val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
val input = br.readLine().split(" ").map { it.toInt() }
private var n: Int = input[0]
private var m: Int = input[1]
private var map = mutableListOf<List<Int>>()
var isVisited: Array<Array<Boolean>> = Array(n) {
    Array(m) { false }
}
var answer: Int = 0

// 테트로미노
fun main() {
    for (i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        map.add(temp)
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            isVisited[i][j] = true
            dfs(i, j, 0, 0)
            isVisited[i][j] = false
            exception(i, j)
        }
    }
    bw.write("$answer")
    bw.flush()
    bw.close()
}

private fun dfs(x: Int, y: Int, depth: Int, sum: Int) {
    if (depth == 4) {
        answer = max(sum, answer)
        return
    }

    for (i in 0 until 4) {
        var nx = x + dx[i]
        var ny = y + dy[i]

        if (nx in 0 until n && ny in 0 until m) {
            if (!isVisited[nx][ny]) {
                isVisited[nx][ny] = true
                dfs(nx, ny, depth + 1, sum + map[nx][ny])
                isVisited[nx][ny] = false
            }
        }
    }
}

fun exception(x: Int, y: Int) {
    // 꼭짓점일 경우
    if (
        (x == 0) && (y == 0) ||
        (x == 0) && (y == m - 1) ||
        (x == n - 1) && (y == 0) ||
        (x == n - 1) && (y == m - 1)
    ) return

    var sum = map[x][y]

    // 모서리가 테두리인 4가지 경우
    if (x == 0) {
        sum += map[x][y - 1] + map[x][y + 1] + map[x + 1][y]
    } else if (x == n - 1) {
        sum += map[x][y - 1] + map[x][y + 1] + map[x - 1][y]
    } else if (y == 0) {
        sum += map[x - 1][y] + map[x + 1][y] + map[x][y + 1]
    } else if (y == m - 1) {
        sum += map[x - 1][y] + map[x + 1][y] + map[x][y - 1]
    } else { // 맵의 테두리가 아닌 경우
        sum = max(sum, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1]) // ㅗ
        sum = max(sum, map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1]) // ㅜ
        sum = max(sum, map[x][y] + map[x][y - 1] + map[x - 1][y] + map[x + 1][y]) // ㅓ
        sum = max(sum, map[x][y] + map[x][y + 1] + map[x - 1][y] + map[x + 1][y]) // ㅏ
    }

    answer = max(answer, sum)
}