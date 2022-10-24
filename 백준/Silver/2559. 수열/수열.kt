import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val br = BufferedWriter(OutputStreamWriter(System.out))
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    for (i in 1 until n) {
        arr[i] = arr[i - 1] + arr[i]
    }

    var ans = arr[k - 1]
    for (i in 0 until n - k) {
        ans = ans.coerceAtLeast(arr[i+k] - arr[i])
    }

    br.write("$ans")
    br.flush()
    br.close()
}