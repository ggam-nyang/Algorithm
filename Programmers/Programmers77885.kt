package Programmers

class Programmers77885 {
    fun solution(numbers: LongArray): List<Int> {
        return numbers
            .map {num -> getF(num.toString(2)) }
    }

    private fun getF(binaryString: String): Int {
        if (binaryString.all { it == '1' }) return "10${binaryString.substring(1)}".toInt(2)

        val lastIdx = binaryString.lastIndexOf('0')
        if (lastIdx == binaryString.lastIndex) return (binaryString.substring(0, lastIdx) + '1').toInt(2)

        if (lastIdx == binaryString.lastIndex - 1)
            return (binaryString.substring(0, lastIdx) + "10").toInt(2)

        return (binaryString.substring(0, lastIdx) + "10" + binaryString.substring(lastIdx + 2)).toInt(2)
    }
}
