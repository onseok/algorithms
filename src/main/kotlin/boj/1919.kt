package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val strFirst = br.readLine()
    val strSecond = br.readLine()
    val arr = Array('z'-'a'+1) {0}
    var result = 0
    for (s in strFirst) {
        arr[(s-'a')] += 1
    }
    for (s in strSecond) {
        arr[(s-'a')] -= 1
    }
    for (i in arr) {
        result += if(i<0) (-1)*i else i
    }
    print(result)
}