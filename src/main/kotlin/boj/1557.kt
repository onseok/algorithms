package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private const val MX = 1e5
private lateinit var mobius: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val k = readln().toLong()
    mobius = IntArray((MX + 1).toInt()) { 1 }
    var i = 2
    while (i*i <= MX) {
        if(mobius[i] == 1) {
            for (j in i .. MX.toInt() step i) mobius[j] *= - i
            for (j in i*i .. MX.toInt() step  i*i) mobius[j] = 0
        }
        i++
    }
    for (i in 2 .. MX.toInt()) {
        if (mobius[i] == i) mobius[i] = 1
        else if (mobius[i] == -i) mobius[i] = -1
        else if (mobius[i] < 0) mobius[i] = 1
        else if (mobius[i] > 0) mobius[i] = -1
    }

    var start: Long = 1
    var end: Long = 2000_000_000
    while (start < end) {
        val mid = (start + end) shr 1
        var value = solve(mid)
        if (value > k) end = mid - 1
        else if (value == k) end = mid
        else start = mid + 1
    }
    println(start)
}

private fun solve(N: Long) : Long {
    var ret:Long = 0
    var i = 1
    while (i*i <= N) {
        ret += mobius[i] * (N / (i * i))
        i++
    }
    return ret
}