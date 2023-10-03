package leetCode.topInterview150.array

class Solution134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var startIndex = 0

        var tank = 0
        var gasSum = 0
        gas.indices.forEach { idx ->
            tank += gas[idx] - cost[idx]
            gasSum += gas[idx] - cost[idx]

            if (tank < 0) {
                tank = 0
                startIndex = idx + 1
            }
        }

        if (gasSum < 0) return -1
        return startIndex
    }
}