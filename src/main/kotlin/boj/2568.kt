package boj

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @author onseok
 */

private data class Pair(var left: Int, var right: Int) : Comparable<Pair> {
    override fun compareTo(other: Pair): Int {
        return left - other.left
    }
}

lateinit var lis: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n) { Pair(0, 0) }
    lis = IntArray(n) // LIS를 이루는 수를 저장할 배열
    val isVisited = BooleanArray(500001) // LIS가 아닌 값을 체크
    val trace = Array(n) { Pair(0, 0) }

    for (i in 0 until n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        arr[i] = Pair(a, b)
        isVisited[a] = true
    }

    arr.sort() // 전봇대 A 인덱스 기준으로 정렬

    var idx = 0 // LIS 찾기

    lis[idx] = arr[0].right
    trace[0] = Pair(0, arr[0].left)
    for (i in 1 until n) {
        if (lis[idx] < arr[i].right) { // arr의 값이 더 크다면 lis배열 맨 뒤에 넣기
            lis[++idx] = arr[i].right
            trace[i] = Pair(idx, arr[i].left)
        } else { // 그렇지 않다면 lower bound를 찾아서 그 위치에 값 쓰기
            var lowerBound = binarySearch(0, idx, arr[i].right)
            lis[lowerBound - 1] = arr[i].right
            trace[i] = Pair(lowerBound - 1, arr[i].left)
        }
    }

    println(n - (idx + 1)) // 없애야 하는 전깃줄의 수 = 총 수열의 길이 - LIS의 길이

    val list = ArrayList<Int>()
    for (i in n - 1 downTo 0) { // LIS 수열 값 담기
        if(trace[i].left == idx) {
            list.add(trace[i].right)
            idx--
        }
    }

    for (a in list) { // LIS가 아닌 수 출력 방지를 위해 false로 바꾸기
        isVisited[a] = false
    }

    for (i in 0 until 500001) {
        if (isVisited[i]) println(i)
    }
}

fun binarySearch(l: Int, r: Int, v: Int): Int {
    var left = l
    var right = r
    while (left < right) {
        val mid = (left + right) / 2
        if (lis[mid] >= v) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return right + 1
}