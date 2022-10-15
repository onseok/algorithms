import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    var start = 0
    var end = arr.size - 1
    var minDiff = Int.MAX_VALUE
    var ansLeft = 0
    var ansRight = arr.size - 1

    while (start < end) {
        val sum = arr[start] + arr[end]
        if (sum.absoluteValue < minDiff) {
            minDiff = sum.absoluteValue
            ansLeft = start
            ansRight = end
        }
        if (sum > 0) end--
        else if (sum < 0) start++
        else break
    }

    println("${arr[ansLeft]} ${arr[ansRight]}")
}