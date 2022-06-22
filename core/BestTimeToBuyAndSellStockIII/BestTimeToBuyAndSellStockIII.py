from typing import List


def maxProfit(prices: List[int]) -> int:
    buy1, buy2, sell1, sell2 = -prices[0], -prices[0], 0, 0
    for index in range(1, len(prices)):
        buy1 = max(buy1, -prices[index])
        sell1 = max(sell1, buy1 + prices[index])
        buy2 = max(buy2, sell1 - prices[index])
        sell2 = max(sell2, buy2 + prices[index])

    return sell2


if __name__ == '__main__':
    print(maxProfit([1,2,3,4,5]))




