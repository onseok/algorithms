package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readln().split(" ").map { it.toInt() }
    val points = Array(4) { Coord(0, 0) }
    repeat(4) { idx ->
        points[idx].x = input[idx * 2]
        points[idx].y = input[idx * 2 + 1]
    }
    val result = if (
        ccw(points[0].x, points[0].y, points[1].x, points[1].y, points[2].x, points[2].y) *
        ccw(points[0].x, points[0].y, points[1].x, points[1].y, points[3].x, points[3].y) < 0 &&
        ccw(points[2].x, points[2].y, points[3].x, points[3].y, points[0].x, points[0].y) *
        ccw(points[2].x, points[2].y, points[3].x, points[3].y, points[1].x, points[1].y) < 0
    ) 1 else 0
    println(result)
}

data class Coord(
    var x: Int,
    var y: Int
)

private fun ccw(
    x1: Int, y1: Int,
    x2: Int, y2: Int,
    x3: Int, y3: Int
): Int {
    var temp = x1 * y2 + x2 * y3 + x3 * y1
    temp -= x1 * y3 + x2 * y1 + x3 * y2
    return if (temp > 0) 1
    else if (temp < 0) -1
    else 0
}