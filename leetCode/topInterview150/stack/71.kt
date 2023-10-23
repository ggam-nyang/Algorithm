package leetCode.topInterview150.stack

class Solution71 {
    fun simplifyPath(path: String): String {
        val directories = path.split("/")
        val stack = ArrayDeque<String>()
        directories.forEach {
            when (it) {
                ".." -> if (stack.isNotEmpty()) stack.removeLast()
                ".", "" -> return@forEach
                else -> stack.add(it)
            }
        }

        return "/" + stack.joinToString("/")
    }
}