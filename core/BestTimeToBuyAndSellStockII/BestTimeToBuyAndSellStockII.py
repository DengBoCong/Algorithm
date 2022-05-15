from typing import List


def maxProfit(prices: List[int]) -> int:
    sell, buy, days = 0, -prices[0], len(prices)
    for day in range(days):
        temp = sell
        sell = max(sell, buy + prices[day])
        buy = max(buy, temp - prices[day])

    return sell



