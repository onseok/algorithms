package coding_test

import kotlin.math.pow

fun main() {
    Solution3().solution("ppwwwbpbbwwbw", "pwbwpwwbw")
}

private class Solution3 {

    var sum = 0.0

    fun solution(S1: String, S2: String): Int {

        dfs(S1, 0, 0)
//        dfs(S2, 0, 0)
        println(sum.toInt())
        var answer = 0
        return answer
    }

    private fun dfs(node: String, idx: Int, depth: Int) {
        if (node[idx] == 'w' || node[idx] == 'b') {
            if (node[idx] == 'b') {
                sum += (1024 / (4.0).pow(depth))
            }
            return
        }
        if (node[idx] == 'p') {
            for (i in 1..4) {
                dfs(node, idx, depth + 1)
            }
        }
    }
}