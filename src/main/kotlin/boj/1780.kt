package boj

import java.io.BufferedReader
import java.io.InputStreamReader

var minusOneCnt: Int = 0
var zeroCnt: Int = 0
var oneCnt: Int = 0
private val arr: MutableList<List<Int>> = mutableListOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val temp = br.readLine().split(' ').map { it.toInt() }
        arr.add(temp)
    }
    partition(0, 0, n)
    println(minusOneCnt)
    println(zeroCnt)
    println(oneCnt)
}

fun partition(row: Int, col: Int, size: Int) {

    if(numCheck(row, col, size)) {
        when (arr[row][col]) {
            -1 -> { minusOneCnt++ }
            0 -> { zeroCnt++ }
            else -> { oneCnt++ }
        }
        return
    }

    val newSize = size / 3

    partition(row, col, newSize) // 왼쪽 위
    partition(row, col + newSize, newSize) // 중앙 위
    partition(row, col + 2*newSize, newSize) // 오른쪽 위

    partition(row + newSize, col, newSize) // 왼쪽 중간
    partition(row + newSize, col + newSize, newSize) // 정중앙
    partition(row + newSize, col + 2*newSize, newSize) // 오른쪽 중간

    partition(row + 2*newSize, col, newSize) // 왼쪽 아래
    partition(row + 2*newSize, col + newSize, newSize) // 중앙 아래
    partition(row + 2*newSize, col + 2*newSize, newSize) // 오른쪽 아래
}

fun numCheck(row: Int, col: Int, size: Int) : Boolean {
    val num = arr[row][col]

    for (i in row until row + size) {
        for (j in col until col + size) {
            if (num != arr[i][j]) return false
        }
    }
    return true
}