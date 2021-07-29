def maxProfit_greed(prices: list) -> int:
    length = len(prices)

    if length == 0:
        return 0
    
    profit = 0
    for i in range(1, length):
        profit = profit + max(prices[i] - prices[i - 1], 0)
    
    return profit

def maxProfit_dp(prices: list) -> int:
    length = len(prices)

    if length == 0:
        return 0
    
    profit1 = 0
    profit2 = -prices[0]
    for i in range(1, length):
        temp = profit1
        profit1 = max(profit1, profit2 + prices[i])
        profit2 = max(profit2, temp - prices[i])
    
    return profit1


if __name__ == "__main__":
    print(maxProfit_dp([7,1,5,3,6,4]))