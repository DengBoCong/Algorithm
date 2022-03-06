from typing import List


def findLUSlength(strs: List[str]) -> int:
    def is_seq(x, y):
        left, right = 0, 0
        while left < len(x) and right < len(y):
            if x[left] == y[right]:
                right += 1
            left += 1
        return right == len(y)

    res = -1
    for i in range(len(strs)):
        j = 0
        while j < len(strs):
            if i == j:
                j += 1
                continue

            if is_seq(strs[j], strs[i]):
                break

            j += 1

        if j == len(strs):
            res = max(res, len(strs[i]))

    return res


if __name__ == '__main__':
    print(findLUSlength(["aaa","aaa","aa"]))
