import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @author onseok
 */

private lateinit var arr: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    val line = readln().split(" ").map { it.toInt() }
    arr = IntArray(n + 1)
    for (i in 1..n) {
        arr[i] = line[i - 1]
    }

    val dp = Array(n + 1) { BooleanArray(n + 1) { false } }

    // 1자리
    for (i in 1 until n + 1) {
        dp[i][i] = true
    }

    // 2자리
    for (i in 1 until n) {
        if (arr[i] == arr[i + 1]) {
            dp[i][i + 1] = true
        }
    }

    // 3자리 이상
    for (i in 2 until n) {
        for (j in 1..n - i) {
            if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                dp[j][j + i] = true
        }
    }

    val m = readln().toInt()
    val sb = StringBuilder()
    repeat(m) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        if (dp[start][end]) sb.append("1\n");
        else sb.append("0\n");
    }
    bw.write("$sb")
    bw.flush()
    bw.close()
}