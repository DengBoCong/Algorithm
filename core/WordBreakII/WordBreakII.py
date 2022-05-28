from typing import List
from collections import deque


def wordBreak(s: str, wordDict: List[str]) -> List[str]:
    res = []
    def dfs(sub_str, remain):
        if sub_str == "":
            res.append(" ".join(remain))
            return

        length = len(sub_str)
        for i in range(length - 1, -1, -1):
            if sub_str[i:] in wordDict:
                remain.appendleft(sub_str[i:])
                dfs(sub_str[:i], remain)
                remain.popleft()
    dfs(s, deque())
    return res


if __name__ == '__main__':
    print(wordBreak("catsanddog", ["cat","cats","and","sand","dog"]))




