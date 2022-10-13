import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map {it.toInt()}
    val sequence = br.readLine().split(" ").map { it.toInt() }

    val sumOfSequence = IntArray(sequence.size + 1) { 0 }

    sequence.forEachIndexed { index, curNum ->
        sumOfSequence[index + 1] = sumOfSequence[index] + curNum
    }

    repeat(m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        val answer = sumOfSequence[end] - sumOfSequence[start-1]
        bw.write("$answer\n")
    }

    bw.flush()
    bw.close()
}