import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val s = br.readLine().toCharArray()
    var ans = 0
    var cnt = 0
    var i = 1
    while (i < m-1) {
        if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {
            cnt++
            if (cnt == n) {
                cnt--
                ans++
            }
            i += 2
        } else {
            cnt = 0
            i += 1
        }
    }
    println(ans)
}