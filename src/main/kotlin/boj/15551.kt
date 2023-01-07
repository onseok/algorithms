package boj

import java.lang.StringBuilder

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()
    for (i in 2 until n) {
        sb.append("*")
    }
    System.out.printf("%s>>\n%s=]\n", sb.toString(), sb.toString())
}
