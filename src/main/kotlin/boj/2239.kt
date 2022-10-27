package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

/**
 * @author onseok
 */

data class Point(
    var x: Int,
    var y: Int
)

var sudoku = Array(9) { IntArray(9) { 0 } }
val zeroPointArray = ArrayList<Point>()
var emptyCount = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(9) { x ->
        val row = readLine()
        repeat(9) { y ->
            sudoku[x][y] = row[y].digitToInt()
            if (sudoku[x][y] == 0) {
                zeroPointArray.add(Point(x, y))
            }
        }
    }
    emptyCount = zeroPointArray.size

    dfs(0)
}

fun findKeys(x: Int, y: Int): ArrayList<Int> {
    val nums = BooleanArray(10) { false }

    for (i in 0 until 9) {
        nums[sudoku[x][i]] = true
    }

    for (i in 0 until 9) {
        nums[sudoku[i][y]] = true
    }

    val squareX = when (x) {
        in 0..2 -> 0
        in 3..5 -> 3
        in 6..8 -> 6
        else -> -1
    }

    val squareY = when (y) {
        in 0..2 -> 0
        in 3..5 -> 3
        in 6..8 -> 6
        else -> -1
    }

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i == x && j == y) continue
            nums[sudoku[squareX + i][squareY + j]] = true
        }
    }

    val result = ArrayList<Int>()
    for (i in 1..9) {
        if (!nums[i]) result.add(i)
    }

    return result
}

private fun dfs(depth: Int) { // depth는 깊이, 즉 현재 채워진 빈칸의 개수를 의미
    if (depth == emptyCount) {
        sudoku.forEach { row ->
            row.forEach { col ->
                print(col)
            }
            println()
        }
        exitProcess(0)
    }

    val point = zeroPointArray[depth]
    val foundKey = findKeys(point.x, point.y)

    for (i in 0 until foundKey.size) {
        sudoku[point.x][point.y] = foundKey[i]
        dfs(depth + 1)
        sudoku[point.x][point.y] = 0
    }
}

