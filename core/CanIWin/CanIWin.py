import functools


def canIWin(maxChoosableInteger: int, desiredTotal: int) -> bool:
    @functools.cache
    def dfs(used_num, cur_total):
        for i in range(maxChoosableInteger):
            if (used_num >> i) & 1 == 0:
                if cur_total + i + 1 >= desiredTotal or not dfs(used_num | (1 << i), cur_total + i + 1):
                    return True
        return False

    return (1 + maxChoosableInteger) * maxChoosableInteger // 2 >= desiredTotal and dfs(0, 0)



