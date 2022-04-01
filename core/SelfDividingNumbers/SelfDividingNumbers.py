from typing import List

def selfDividingNumbers(left: int, right: int) -> List[int]:
    def is_div(num):
        if num == 0:
            return False
        remain = num
        while num != 0:
            if num % 10 == 0 or remain % (num % 10) != 0:
                return False
            num /= 10
        return True

    res = []
    for i in range(left, right + 1):
        if is_div(i):
            res.append(i)

    return res

