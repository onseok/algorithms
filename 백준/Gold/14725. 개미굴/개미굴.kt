import java.util.*

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