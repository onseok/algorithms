package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


private const val MOD = 1_000_000_007
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toLong()
    val br = BufferedWriter(OutputStreamWriter(System.out))
    br.write("${fibonacci(n)[0][1]}")
    br.flush()
    br.close()
}

private fun multiplyMatrix(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    val arr = Array(2) { LongArray(2) }
    arr[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD
    arr[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD
    arr[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD
    arr[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD
    return arr
}

private fun fibonacci(n: Long): Array<LongArray> {
    return if (n == 1L) {
        val arr: Array<LongArray> = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
        arr
    } else {
        val tmp = fibonacci(n / 2)
        if (n % 2 == 1L) {
            multiplyMatrix(multiplyMatrix(tmp, tmp), fibonacci(1))
        } else {
            multiplyMatrix(tmp, tmp)
        }
    }
}

