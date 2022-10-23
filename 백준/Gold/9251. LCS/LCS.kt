import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val first = readLine()
    val second = readLine()
    val lcs = Array(first.length + 1) { IntArray(second.length + 1) }
    for (i in 1..first.length) {
        for (j in 1..second.length) {
            if (first[i - 1] == second[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
            }
        }
    }
    println(lcs[first.length][second.length])
}