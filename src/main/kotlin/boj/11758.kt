package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val points = Array(3) { P(0, 0) }
    repeat(3) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        points[it].x = x
        points[it].y = y
    }

    val a = points[0].x * points[1].y + points[1].x * points[2].y + points[2].x * points[0].y
    val b = points[0].y * points[1].x + points[1].y * points[2].x + points[2].y * points[0].x

    if (a > b) { // 반시계 방향
        println(1)
    } else if (a == b) { // 일직선
        println(0)
    } else { // 시계 방향
        println(-1)
    }
}

data class P(
    var x: Int,
    var y: Int
)