import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val origin = readln()
    val bomb = readln()
    val sb = StringBuilder()
    for (element in origin) {
        val ch = element
        sb.append(ch)
        if (sb.length >= bomb.length) {
            // 폭발 문자열과 서브 문자열이 같은지 검사
            var isSame = true
            for (j in bomb.indices) {
                val c1 = sb[sb.length - bomb.length + j]
                val c2 = bomb[j]
                if (c1 != c2) {
                    isSame = false
                    break
                }
            }
            if (isSame) {
                sb.delete(sb.length - bomb.length, sb.length)
            }
        }
    }
    if (sb.isEmpty()) {
        println("FRULA")
    } else {
        println(sb.toString())
    }
}