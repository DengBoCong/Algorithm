def maxProfit_dp(k: int, prices: list) -> int:
    length = len(prices)

    if length == 0 or k == 0:
        return 0
    
    buy = [-prices[0] for i in range(k)]
    sell = [0 for i in range(k)]
    for i in range(1, length):
        buy[0] = max(buy[0], -prices[i])
        sell[0] = max(sell[0], buy[0] + prices[i])
        for j in range(1, k):
            buy[j] = max(buy[j], sell[j - 1] - prices[i])
            sell[j] = max(sell[j], buy[j] + prices[i])
        
    return max(sell)

def maxProfit_wqs_binary(k: int, prices: list) -> int:
    """
    wqs二分查找解法
    """
    if not prices:
        return 0

    n = len(prices)
    # 二分查找的上下界
    left, right = 1, max(prices)
    # 存储答案，如果值为 -1 表示二分查找失败
    ans = -1

    while left <= right:
        # 二分得到当前的斜率（手续费）
        c = (left + right) // 2

        # 使用与 714 题相同的动态规划方法求解出最大收益以及对应的交易次数
        buyCount = sellCount = 0
        buy, sell = -prices[0], 0

        for i in range(1, n):
            if sell - prices[i] >= buy:
                buy = sell - prices[i]
                buyCount = sellCount
            if buy + prices[i] - c >= sell:
                sell = buy + prices[i] - c
                sellCount = buyCount + 1

        # 如果交易次数大于等于 k，那么可以更新答案
        # 这里即使交易次数严格大于 k，更新答案也没有关系，因为总能二分到等于 k 的
        if sellCount >= k:
            # 别忘了加上 kc
            ans = sell + k * c
            left = c + 1
        else:
            right = c - 1

    # 如果二分查找失败，说明交易次数的限制不是瓶颈
    # 可以看作交易次数无限，直接使用贪心方法得到答案
    if ans == -1:
        ans = sum(max(prices[i] - prices[i - 1], 0) for i in range(1, n))

    return ans

if __name__ == "__main__":
    print(maxProfit_wqs_binary(2, [3,2,6,5,0,3]))