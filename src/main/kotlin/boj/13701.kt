package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.BitSet

private const val BITSET_SIZE = 33554432
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readln().split(" ").map { it.toInt() }
    val bitSet = BitSet(BITSET_SIZE)
    val sb = StringBuilder()

    for (i in input.indices) {
        if(!bitSet.get(input[i])) {
            bitSet.set(input[i])
            sb.append(input[i]).append(" ")
        }
    }

    println(sb)
}