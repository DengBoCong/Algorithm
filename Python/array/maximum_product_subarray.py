import sys
from typing import List

def maxProduct(nums: List[int]) -> int:
    result, imax, imin = -sys.maxsize, 1, 1
    for num in nums:
        re1, re2 = imax, imin
        imax = max(re1 * num, re2 * num, num)
        imin = min(re2 * num, re1 * num, num)
        result = max(result, imax)
    
    return result

if __name__ == "__main__":
    print(maxProduct([-4,-3,-2]))