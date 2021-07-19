from typing import *

def singleNumber(nums: List[int]) -> int:
    count = [0] * 32
    for num in nums:
        for i in range(32):
            count[i] += num & 1
            num >>= 1

    res = 0
    for i in range(31, -1, -1):
        res <<= 1
        if count[i] % 3 == 1:
            res += 1
    return res

if __name__ == "__main__":
    print(singleNumber([9,1,7,9,7,9,7]))