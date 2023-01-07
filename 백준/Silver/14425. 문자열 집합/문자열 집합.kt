package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.TreeMap

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val trie = Trie<Char>()
    var ans = 0
    repeat(n) {
        trie.insert(readLine())
    }
    repeat(m) {
        if (trie.contains(readLine())) ans++
    }
    println(ans)
}

class TrieNode<Key>(var key: Key?, var parent: TrieNode<Key>?) {
    val children: TreeMap<Key, TrieNode<Key>> = TreeMap()
    var isTerminating = false
}

class Trie<Key> {
    private val root = TrieNode<Key>(key = null, parent = null)

    fun insert(list: List<Key>) {
        var current = root

        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }

        current.isTerminating = true
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }
}

fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}
fun Trie<Char>.contains(string: String): Boolean {
    return contains(string.toList())
}