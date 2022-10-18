import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toLong() }.toLongArray()
    arr.sort()
    var minDiff = Long.MAX_VALUE
    var minTriple = Triple(0L, 0L, 0L)
    for (i in arr.indices) {
        val first = arr[i] // 세 용액 중 첫 번째 용액
        var left = i + 1 // 세 용액 중 두 번째 용액으로 정할 용액의 인덱스
        var right = arr.lastIndex // 세 용액 중 세 번째 용액으로 정할 용액의 인덱스
        while (left < right) {
            val sum = first + arr[left] + arr[right]
            if (sum.absoluteValue < minDiff) {
                minDiff = sum.absoluteValue
                minTriple = Triple(first, arr[left], arr[right])
            }
            if (sum > 0) right--
            else left++
        }
    }

    println(minTriple.toList().joinToString(" "))
}