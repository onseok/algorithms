package coding_test

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val words: Array<String> = arrayOf("one", "one", "two", "one")
//    val words: Array<String> = arrayOf("may", "with", "may", "you", "you")
    Solution2().solution(words)
}

private class Solution2 {
    fun solution(words: Array<String>): LongArray {
        var answer = LongArray(words.size)
        val intMap = HashMap<String, Long>()
        val booleanMap = HashMap<String, Boolean>()

        words.forEachIndexed { index, s ->
            if (!booleanMap.getOrDefault(s, false)) {
                booleanMap[s] = true
                intMap[s] = (index + 1).toLong()
            }
        }

        words.forEachIndexed { index, s ->
            answer[index] = intMap.getOrDefault(s, 0)
        }

        return answer
    }
}