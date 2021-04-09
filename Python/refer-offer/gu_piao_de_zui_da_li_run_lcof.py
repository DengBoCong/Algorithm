from typing import *

def maxProfit(prices: List[int]) -> int:
    length = len(prices)
    if length < 2:
        return 0
    buy, sell = -prices[0], 0
    for i in range(1, length):
        buy = max(buy, -prices[i])
        sell = max(sell, buy + prices[i])
    
    return sell

if __name__ == "__main__":
    print(maxProfit([7,1,5,3,6,4]))