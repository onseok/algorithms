import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readln().toLong()
    var pi = n
    var i: Long = 2
    while (i * i <= n) {
        if (n % i == 0L) {
            pi = pi / i * (i - 1)
        }
        while (n % i == 0L) {
            n /= i
        }
        i++
    }
    if (n != 1L) {
        pi = pi / n * (n -1)
    }
    println(pi)
}