package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private const val p: Long = 1000000007
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readln().split(" ").map { it.toLong() }

    // 분자 N!
    val number = factorial(n)

    // 분모 (K! * (N-K)!) mod p
    val denom = factorial(k) * factorial(n - k) % p

    // N! * 분모의 역원((K! * (N-K)!)
    println(number * pow(denom, p - 2) % p)
}

private fun factorial(n: Long): Long {
    var fac = 1L
    var num = n

    while (num > 1) {
        fac = (fac * num) % p
        num--
    }
    return fac
}

/**
 * 역원 구하는 함수
 *
 * base : 밑,   expo = 지수 (exponent)
 *
 * 거듭 제곱을 분할 정복 방식으로 푼다.
 *
 */
private fun pow(base: Long, expo: Long): Long {
    // 지수가 1일 경우 base^1 이므로 base % P를 리턴
    if (expo == 1L) {
        return base % p
    }

    // 지수의 절반에 해당하는 base^(expo / 2) 을 구한다.
    val temp = pow(base, expo / 2)

    // 현재 지수가 홀수였다면
    // base^(expo / 2) * base^(expo / 2) * base 이므로
    // base를 한 번 더 곱해주어야 한다.
    // ex) A^9 = A^4 * A^4 * A
    if (expo % 2 == 1L) {
        return (temp * temp % p) * base % p
    }
    return temp * temp % p
}