import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

/**
 * @author onseok
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val seq = readLine().split(" ").map { it.toInt() }
    val index = IntArray(n)
    val lis = IntArray(n)

    lis[0] = seq[0]
    index[0] = 1
    var lengthOfLis = 1

    for (i in 1 until n) {
        val key = seq[i]
        if (lis[lengthOfLis - 1] < key) {
            lengthOfLis++
            lis[lengthOfLis - 1] = key
            index[i] = lengthOfLis
        } else {
            var low = 0
            var high = lengthOfLis
            while (low < high) {
                val mid = (low + high) / 2
                if (lis[mid] < key) {
                    low = mid + 1
                } else {
                    high = mid
                }
            }
            index[i] = low + 1
            lis[low] = key
        }
    }

    val stack = Stack<Int>()
    var idx = lengthOfLis
    for (i in n - 1 downTo 0) {
        if (index[i] == idx) {
            idx--
            stack.push(seq[i])
        }
        if (idx == 0) break
    }

    val sb = StringBuilder()

    while (!stack.isEmpty()) {
        sb.append("${stack.pop()} ")
    }

    bw.write("$lengthOfLis\n")
    bw.write("$sb")
    bw.flush()
    bw.close()
    close()
}