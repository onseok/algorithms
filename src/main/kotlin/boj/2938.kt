package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    val arr = IntArray(n)
    val sb = StringBuilder()
    val qArr = Array<Queue<Int>>(3) { LinkedList() }

    val seq = readln().split(" ").map { it.toInt() }
    seq.forEachIndexed { index, i ->
        arr[index] = i
        qArr[arr[index] % 3].offer(arr[index])
    }

    // 불가능한 경우
    if (qArr[0].size > (n + 1) / 2 ||
        (qArr[0].isEmpty() && qArr[1].isNotEmpty() && qArr[2].isNotEmpty())
    ) {
        println(-1)
        return@with
    }

    // 1을 차례차례 출력해주면서, 남아도는 0을 처리해준다. (1개는 남겨둬야 함)
    while (qArr[1].isNotEmpty()) {
        if (qArr[0].size > 1) {
            sb.append("${qArr[0].poll()} ")
        }
        sb.append("${qArr[1].poll()} ")
    }

    // 1과 2를 떼어놓을 0을 출력한다
    // 0이 없으면 1만 있거나 2만 있는 경우다
    if (qArr[0].isNotEmpty()) {
        sb.append("${qArr[0].poll()} ")
    }

    // 2를 차례차례 출력해주면서, 남아도는 0을 처리해준다
    while (qArr[2].isNotEmpty()) {
        sb.append("${qArr[2].poll()} ")
        if (qArr[0].isNotEmpty()) {
            sb.append("${qArr[0].poll()} ")
        }
    }

    print(sb.toString())
}