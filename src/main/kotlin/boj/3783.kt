package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

/**
 * @author onseok
 */

fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val num = br.readLine().toBigDecimal()
        write("${cubeRoot(num).setScale(10, RoundingMode.DOWN)}\n")
    }
    flush()
    close()
}

fun cubeRoot(b: BigDecimal): BigDecimal {
    val mc = MathContext(1000)
    var x = BigDecimal("1", mc)

    for (i in 0 until 1000) {
        x = x.subtract(
            x.pow(3, mc)
                .subtract(b, mc)
                .divide(
                    BigDecimal("3", mc).multiply(
                        x.pow(2, mc), mc
                    ), mc
                ), mc
        )
    }
    return x
}


