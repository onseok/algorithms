package boj

import java.util.*

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

    fun print() {
        print(current = root, floor = 0)
    }

    fun print(current: TrieNode<Key>?, floor: Int) {
        val set = current?.children?.keys
        val iterator = set?.iterator()

        while (iterator?.hasNext() == true) {
            val str = iterator.next()
            val childNode = current.children[str]
            for (i in 0 until floor) {
                print("--")
            }
            println(str)
            print(childNode, floor + 1)
        }
    }
}

fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}

fun Trie<Char>.contains(string: String): Boolean {
    return contains(string.toList())
}