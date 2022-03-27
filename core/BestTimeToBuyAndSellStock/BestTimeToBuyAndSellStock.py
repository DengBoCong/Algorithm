from typing import List

def maxProfit(prices: List[int]) -> int:
    buy, sell = -prices[0], 0
    res = sell
    for i in range(1, len(prices)):
        temp_buy = buy
        buy = max(buy, -prices[i])
        sell = max(sell, temp_buy + prices[i])
        res = max(res, sell)

    return res



