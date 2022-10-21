package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var par: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val gateNum = readLine().toInt()
    val planeNum = readLine().toInt()
    par = IntArray(gateNum + 1) { i -> i }

    var ans = 0

    for (i in 0 until planeNum) {
        val g = readLine().toInt()
        val emptyGate = find(g)
        if (emptyGate == 0) {
            break
        }
        ans++
        union(emptyGate, emptyGate - 1)
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
    close()
}

private fun find(x: Int): Int {
    if (x != par[x]) par[x] = find(par[x])
    return par[x]
}

private fun union(a: Int, b: Int) {
    val aParent = find(a)
    val bParent = find(b)
    if (aParent != bParent) {
        par[aParent] = bParent
    }
}