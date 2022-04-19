from typing import List


def lexicalOrder(n: int) -> List[int]:
    res = []

    def order(num):
        for i in range(10):
            if num * 10 + i > n:
                return
            res.append(num * 10 + i)
            order(num * 10 + i)

    for k in range(1, 10):
        if k > n:
            break
        res.append(k)
        order(k)

    return res


