package coding_test

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(Solution1().solution(33))
}

private class Solution1 {
    fun solution(num: Int): Int {

        var answer: Int = 0
        for (idx in 1..num) {
            if (idx.toString().isThreeSixNine()) {
                answer++
            }
        }

        return answer
    }

    private fun String.isThreeSixNine(): Boolean {
        return this.contains("3") ||
                this.contains("6") ||
                this.contains("9")
    }
}