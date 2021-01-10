def maxProfit(prices: list) -> int:
    length = len(prices)
    if length == 0:
        return 0
    
    sell1 = 0
    sell2 = 0
    buy1 = -prices[0]
    buy2 = -prices[0]
    for i in range(1, length):
        temp2 = sell1
        sell1 = max(sell1, buy1 + prices[i])
        sell2 = max(sell2, buy2 + prices[i])
        buy1 = max(buy1, -prices[i])
        buy2 = max(buy2, temp2 - prices[i])
    
    return max(0, sell1, sell2)

if __name__ == "__main__":
    print(maxProfit([2,1,4,5,2,9,7]))