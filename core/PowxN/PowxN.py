def myPow(x: float, n: int) -> float:
    def cal(num, count):
        if count == 0:
            return 1
        return cal(num * num, count // 2) * (1 if count % 2 == 0 else num)
    res = cal(x, abs(n))
    if n >= 0:
        return res
    else:
        return 1 / res



