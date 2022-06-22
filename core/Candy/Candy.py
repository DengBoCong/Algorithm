from typing import List


def candy(ratings: List[int]) -> int:
    res, point, pre, remain = 1, 0, 1, 1
    for i in range(1, len(ratings)):
        if ratings[i] >= ratings[i - 1]:
            pre = pre + 1 if ratings[i] != ratings[i - 1] else 1
            res += pre
            point = i
            remain = pre
        else:
            res += i - point + 1 if i - point + 1 > remain else i - point
            pre = 1

    return res

if __name__ == '__main__':
    print(candy([1,2,2]))

