package boj

import java.io.BufferedReader
import java.io.InputStreamReader

// 뒤에 0이나오는 경우는 10이 곱해진 경우밖에 없다.
// 10 = 2*5이므로 N!을 소인수분해 했을 때 나오는 2와 5의 개수를 세서 min(2의 개수, 5의 개수)를 구하면 된다.
// 그런데, 생각해보면 5의 개수가 항상 2의 개수보다 적기 때문에 5의 개수만 세면 된다.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var cnt = 0
    for (i in 5..n) {
        var j = i
        while (j % 5 == 0) {
            cnt++
            j /= 5
        }
    }
    print(cnt)
}