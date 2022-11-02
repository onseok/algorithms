package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private const val MOD: Long = 1_000_000_007
private const val SIZE: Int = 4_000_001
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val fact = LongArray(SIZE)
    fact[0] = 1L
    fact[1] = 1L
    for (i in 2 until SIZE) {
        fact[i] = fact[i - 1] * i % MOD
    }
    val m = readln().toInt()
    val sb = StringBuilder()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        sb.append(fact[a] * pow(fact[a - b] * fact[b] % MOD, MOD - 2) % MOD).append("\n")
    }
    println(sb.toString())
}

private fun pow(base: Long, expo: Long): Long {
    // 지수가 1일 경우 base^1 이므로 base % P를 리턴
    if (expo == 1L) {
        return base % MOD
    }

    // 지수의 절반에 해당하는 base^(expo / 2) 을 구한다.
    val temp = pow(base, expo / 2)

    // 현재 지수가 홀수였다면
    // base^(expo / 2) * base^(expo / 2) * base 이므로
    // base를 한 번 더 곱해주어야 한다.
    // ex) A^9 = A^4 * A^4 * A
    if (expo % 2 == 1L) {
        return (temp * temp % MOD) * base % MOD
    }
    return temp * temp % MOD
}