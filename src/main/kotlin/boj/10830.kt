package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private const val MOD: Int = 1_000
private var n = 0
private lateinit var matrix: Array<IntArray>
private lateinit var unitMatrix: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = readLine().split(" ")
    n = input[0].toInt()
    val b = input[1].toLong()
    matrix = Array(n) { IntArray(n) }
    unitMatrix = Array(n) { IntArray(n) { 1 } }
    for (m in matrix) {
        val inputRow = readln().split(" ").map { it.toInt() }
        for (i in m.indices) {
            m[i] = inputRow[i]
        }
    }
    val res = solve(b)

    for (i in 0 until n) {
        for (j in 0 until n) {
            bw.write("${res[i][j]} ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

private fun solve(cnt: Long): Array<IntArray> {
    if (cnt == 0L) {
        return unitMatrix
    }
    if (cnt == 1L) {
        return matrix
    }

    val result = solve(cnt / 2L)

    return if (cnt % 2 == 1L) {
        calculate(result, calculate(result, solve(1)))
    } else {
        calculate(result, result)
    }
}

private fun calculate(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
    val tmp = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                tmp[i][j] += (a[i][k] * b[k][j]) % MOD
            }
            tmp[i][j] %= MOD
        }
    }
    return tmp
}