from typing import List


def coinChange(coins: List[int], amount: int) -> int:
    remain = {0: 0}
    for index in range(1, amount + 1):
        mid = -1
        for coin in coins:
            if index - coin >= 0 and (index - coin) in remain:
                mid = remain[index - coin] if mid == -1 else min(mid, remain[index - coin])
        if mid != -1:
            remain[index] = mid + 1

    return remain[amount] if amount in remain else -1


if __name__ == '__main__':
    print(coinChange([1, 2, 5], 11))
