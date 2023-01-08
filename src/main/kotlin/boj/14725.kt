package boj

fun main() {
    val n = readln().toInt()
    val trie = Trie<String>()
    repeat(n) {
        val input = readln().split(" ")
        val k = input[0].toInt()
        val sb = StringBuilder()
        for (j in 1..k) {
            if (j != k) sb.append(input[j] + ",")
            else sb.append(input[j])
        }
        trie.insert(sb.split(","))
    }

    trie.print()
}

