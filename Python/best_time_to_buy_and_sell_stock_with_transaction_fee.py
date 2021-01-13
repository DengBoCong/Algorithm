def max_profit_dp(prices: list, fee: int) -> int:
    if not prices:
        return 0
    
    length = len(prices)
    buy, sell = -prices[0], 0
    for i in range(1, length):
        temp = buy
        buy = max(buy, sell - prices[i])
        sell = max(sell, temp + prices[i] - fee)
    
    return max(0, sell)

if __name__ == "__main__":
    print(max_profit_dp([1, 3, 2, 8, 4, 9], 2))