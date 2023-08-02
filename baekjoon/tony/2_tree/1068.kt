package baekjoon.tony.`2_tree`

private lateinit var tree: Array<ArrayList<Int>>
fun main() {
    val n = readln().toInt()
    tree = Array(n) { arrayListOf() }
    val treeInfo = readln().split(" ").map(String::toInt)
    treeInfo.forEachIndexed { index, parent ->
        if (parent != -1) tree[parent].add(index)
    }

    val target = readln().toInt()
    val totalLeafCount = tree.count { it.isEmpty() }
    val targetSubtreeLeafCount = countLeaf(target)

    val answer = totalLeafCount - targetSubtreeLeafCount
    if (tree.find { it.contains(target) }?.size == 1) println(answer + 1)
    else println(answer)
}

private fun countLeaf(target: Int): Int {
    var count = 0
    val children = tree[target]
    if (children.isEmpty()) return 1

    children.forEach {
        count += countLeaf(it)
    }

    return count
}