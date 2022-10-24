import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

/**
 * @author onseok
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val strNormal = readLine().toString()
    val strReversed = strNormal.reversed()
    val lcs = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..strNormal.length) {
        for (j in 1..strReversed.length) {
            if (strNormal[i - 1] == strReversed[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
            }
        }
    }
    println(n - lcs[strNormal.length][strReversed.length])
}