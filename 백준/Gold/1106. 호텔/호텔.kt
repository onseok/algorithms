import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // c : 늘려야 하는 고객의 수 (1000 이하)
    // n : 도시의 갯수 (20 이하)
    // cost : 각 도시에서 홍보할 때 드는 비용 (100 이하)
    // num : 그 비용으로 얻을 수 있는 고객의 수 (100 이하)
    // c + 101 : 늘려야 하는 고객 수 + 최대 도시 고객 수
    val (c, n) = readLine().split(" ").map { it.toInt() }
    val dp = Array(c + 101) { 987654321 }
    dp[0] = 0
    repeat(n) {
        val (cost, num) = readLine().split(" ").map { it.toInt() }
        for (i in num until c + 101) {
            dp[i] = min(dp[i], cost + dp[i - num])
        }
    }
    var ans = Int.MAX_VALUE
    for (i in c until c + 101) {
        ans = min(ans, dp[i])
    }
    println(ans)
}