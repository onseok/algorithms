import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = readln().split(" ").map { it.toLong() }
    val result = if (
        ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0 &&
        ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0) 1
    else 0
    println(result)
}

private fun ccw(
    x1: Long, y1: Long,
    x2: Long, y2: Long,
    x3: Long, y3: Long
): Long {
    var temp = x1 * y2 + x2 * y3 + x3 * y1
    temp -= x1 * y3 + x2 * y1 + x3 * y2
    return if (temp > 0) 1
    else if (temp < 0) -1
    else 0
}