package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        bw.write(strfry(a,b) + "\n")
    }
    bw.flush()
    bw.close()
}


fun strfry(a: String, b: String) : String {
    val arrFirst = Array('z'-'a'+1){0}
    val arrSecond = Array('z'-'a'+1){0}
    for (i in a) {
        arrFirst[i-'a'] += 1
    }
    for (i in b) {
        arrSecond[i-'a'] += 1
    }
    return if (arrFirst.contentEquals(arrSecond)) {
        "Possible"
    } else {
        "Impossible"
    }
}