package leetCode.topInterview150.array

class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        var tempStock = Stock()
        val stockList = arrayListOf<Stock>()

        prices.forEach { price ->
            println(price)
            println(stockList)
            if (tempStock.buyPrice > price) {
                stockList.add(tempStock)
                tempStock = Stock(buyPrice = price)
            }
            if (tempStock.sellPrice < price) tempStock.sellPrice = price
            stockList.add(tempStock)
            tempStock = Stock(price, price)
        }

        return stockList.sumOf { it.sum() }
    }
}

data class Stock(
    var buyPrice: Int = Int.MAX_VALUE,
    var sellPrice: Int = Int.MIN_VALUE
) {
    fun sum(): Int {
        return if (sellPrice > buyPrice) sellPrice - buyPrice else 0
    }
}