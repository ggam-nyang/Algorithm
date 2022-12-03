package Programmers// 효율성 Retry!!

class Programmers92344 {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var wellTowerCnt = board.size * board[0].size
        skill.forEach { sk ->
            wellTowerCnt += applySkill(board, sk)
//            board.forEach {
//                it.forEach { print(it) }
//                println()
//            }
        }

        return wellTowerCnt
    }

    private fun applySkill(board: Array<IntArray>, sk: IntArray): Int {
        val offenseLevel = if (sk[0] == 1) -1 else 1
        val power = sk.last() * offenseLevel
        var target: Int
        var result = 0
        for (r in sk[1] .. sk[3]) {
            for (c in sk[2] .. sk[4]) {
                target = board[r][c]
                if (target > 0 && target + power <= 0)
                    result --
                else if (target <= 0 && target + power > 0)
                    result ++

                board[r][c] += power
            }
        }

        return result
    }
}