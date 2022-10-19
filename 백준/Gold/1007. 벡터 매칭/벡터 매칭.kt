import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

var result = 0.0
lateinit var isChecked: BooleanArray
lateinit var pointArr: Array<IntArray>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        result = Double.MAX_VALUE
        isChecked = BooleanArray(n)
        pointArr = Array(n) { IntArray(2) }
        repeat(n) { index ->
            val (x, y) = readLine().split(" ").map { it.toInt() }
            pointArr[index][0] = x
            pointArr[index][1] = y
        }

        combination(0, n / 2)
        println(result)
    }

    close()
}

private fun combination(index: Int, count: Int) {
    if (count == 0) { // 조합할 원소의 갯수가 더 이상 없는 경우
        result = min(result, getVector())
    } else { // 조합할 원소의 갯수가 남아 있는 경우
        for (i in index until pointArr.size) {
            isChecked[i] = true
            combination(i + 1, count - 1)
            isChecked[i] = false
        }
    }
}

private fun getVector(): Double {
    var x = 0
    var y = 0

    for (i in pointArr.indices) {
        if (isChecked[i]) { // 양수로 선택된 점일 경우
            x += pointArr[i][0]
            y += pointArr[i][1]
        } else { // 음수로 선택된 점일 경우
            x -= pointArr[i][0]
            y -= pointArr[i][1]
        }
    }

    return sqrt(x.toDouble().pow(2.0) + y.toDouble().pow(2.0))
}