def maxProfit(prices):
    """
    :type prices: List[int]
    :rtype: int
    """
    length = len(prices)

    if length ==0:
        return 0

    profit = 0
    bottom = prices[0]
    for i in range(0, length):
        profit = max(profit, prices[i] - bottom)
        if bottom > prices[i]:
            bottom = prices[i]
    
    return profit

if __name__ == "__main__":
    print(maxProfit(prices=[7,1,5,3,6,4]))