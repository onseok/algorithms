import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = ArrayList<Int>()
    var ans = Int.MIN_VALUE
    for (i in 0 until 8) {
        val s = readLine().toInt()
        arr.add(s)
    }
    repeat(8) { idx ->
        ans = max(ans, arr[(idx % 8)] + arr[(idx + 1) % 8] + arr[(idx + 2)  % 8] + arr[(idx + 3) % 8])
    }
    println(ans)
}