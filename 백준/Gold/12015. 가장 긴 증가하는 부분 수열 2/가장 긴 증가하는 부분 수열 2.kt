package boj
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @author onseok
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val seq = readLine().split(" ").map { it.toInt() }
    val lis = IntArray(n)

    lis[0] = seq[0]
    var lengthOfLis = 1

    for (i in 1 until n) {
        val key = seq[i]
        if (lis[lengthOfLis - 1] < key) { // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
            lengthOfLis++
            lis[lengthOfLis - 1] = key
        } else { // 이분 탐색을 진행해준다.
            var low = 0
            var high = lengthOfLis
            while (low < high) {
                val mid = (low + high) / 2
                if (lis[mid] < key) {
                    low = mid +1
                } else {
                    high = mid
                }
            }
            // low가 대치 될 원소의 위치가 될 것이고,
            // 해당 위치에 key값으로 원소를 바꿔준다.
            lis[low] = key
        }
    }
    println(lengthOfLis)
}