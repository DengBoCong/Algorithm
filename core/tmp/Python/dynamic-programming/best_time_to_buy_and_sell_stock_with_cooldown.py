def maxProfit_dp(prices: list) -> int:
    if not prices:
        return 0

    length = len(prices)
    buy, sell, freeze = -prices[0], 0, 0
    for i in range(1, length):
        buy1, sell1 = buy, sell
        buy = max(buy, freeze - prices[i])
        sell = max(sell, buy1 + prices[i])
        freeze = max(freeze, sell1)

    return max(sell, freeze)


def maxProfit_memo_recursion(prices: list) -> int:
    def trade(prices: list, day: int, state: int, memo: list) -> int:
        if day >= len(prices):
            return 0

        if memo[day][state] != -1:
            return memo[day][state]

        buy, sell = 0, 0
        if state == 0:
            sell = prices[day] + trade(prices, day + 2, 1, memo)
        else:
            buy = -prices[day] + trade(prices, day + 1, 0, memo)

        freeze = trade(prices, day + 1, state, memo)
        memo[day][state] = max(buy, sell, freeze)
        return memo[day][state]

    if not prices:
        return 0

    memo = [[-1, -1] for i in range(len(prices))]
    return trade(prices, 0, 1, memo)


if __name__ == "__main__":
    print(maxProfit_memo_recursion([1, 2, 3, 0, 2]))
