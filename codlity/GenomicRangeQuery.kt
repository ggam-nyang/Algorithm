package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
    val charArray = S.toCharArray()
    val size = S.length
    val arrayOfA = IntArray(size + 1)
    val arrayOfC = IntArray(size + 1)
    val arrayOfG = IntArray(size + 1)

    makeArrays(charArray, arrayOfA, arrayOfC, arrayOfG)

    val answer = IntArray(P.size)
    P.indices.map { k ->
        val left = P[k]
        val right = Q[k]

        answer[k] = when {
            left == right -> Nucleotide.valueOf(charArray[left].toString()).impactFactor
            arrayOfA[right + 1] > arrayOfA[left] -> Nucleotide.A.impactFactor
            arrayOfC[right + 1] > arrayOfC[left] -> Nucleotide.C.impactFactor
            arrayOfG[right + 1] > arrayOfG[left] -> Nucleotide.G.impactFactor
            else -> Nucleotide.T.impactFactor
        }
    }

    return answer
}

private fun makeArrays(
    charArray: CharArray,
    arrayOfA: IntArray,
    arrayOfC: IntArray,
    arrayOfG: IntArray
) {
    charArray.indices.forEach { i ->
        when (charArray[i]) {
            'A' -> arrayOfA[i + 1]++
            'C' -> arrayOfC[i + 1]++
            'G' -> arrayOfG[i + 1]++
        }

        arrayOfA[i + 1] += arrayOfA[i]
        arrayOfC[i + 1] += arrayOfC[i]
        arrayOfG[i + 1] += arrayOfG[i]
    }
}

enum class Nucleotide(val impactFactor: Int) {
    A(1),
    C(2),
    G(3),
    T(4)
}
