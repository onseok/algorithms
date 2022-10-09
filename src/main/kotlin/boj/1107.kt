package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

// 1. N까지 + 또는 - 버튼으로만 움직이는 경우
// 2. N과 가까운 번호를 누른 후, + 또는 - 버튼으로 움직이는 경우
var brokenButtons: List<Int> = mutableListOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    brokenButtons = br.readLine().split(" ").map { it.toInt() }

    var minCount = abs(n - 100) // +, -로만 누르는 경우
    for (i in 0 ..500000) {
        val len = check(i) // 숫자 버튼 누르는 횟수
        if (len > 0) {
            var press = abs(n - i)
            minCount = min(minCount, len + press) // 최소 이동 횟수 계산
        }
    }

    print(minCount)
}

fun check(n: Int) : Int {
    var num = n
    if (num == 0) {
        return if (brokenButtons.contains(0)) {
            0
        } else {
            1
        }
    }
    var len = 0
    while (num > 0) {
        if (brokenButtons.contains(num % 10)) { // 고장난 버튼이 있는 경우
            return 0
        }
        num /= 10
        len += 1 // 숫자 버튼 누루는 횟수 증가
    }
    return len
}

