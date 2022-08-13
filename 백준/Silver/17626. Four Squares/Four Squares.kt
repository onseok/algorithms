import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = IntArray(n + 1)
    dp[1] = 1
    var min = 0
    for (i in 2..n) {
        min = Int.MAX_VALUE

        // i에서 i보다 작은 제곱수에서 뺀 dp[i - j * j] 중
        // 최소를 택한다.
        var j = 1
        while (j * j <= i) {
            val temp = i - j * j
            min = min(min, dp[temp])
            j++
        }
        dp[i] = min + 1 // 그리고 1을 더해준다.
    }
    print(dp[n])
}