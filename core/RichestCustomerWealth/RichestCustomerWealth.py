from typing import List

def maximumWealth(accounts: List[List[int]]) -> int:
    res = 0
    for custom in accounts:
        res = max(res, sum(custom))
    return res





