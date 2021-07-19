import collections
from typing import List

def subarraysWithKDistinct(A: List[int], K: int) -> int:
    n = len(A)
    num1, num2 = collections.Counter(), collections.Counter()
    tot1 = tot2 = 0
    left1 = left2 = right = 0
    ret = 0

    for right, num in enumerate(A):
        if num1[num] == 0:
            tot1 += 1
        num1[num] += 1
        if num2[num] == 0:
            tot2 += 1
        num2[num] += 1

        while tot1 > K:
            num1[A[left1]] -= 1
            if num1[A[left1]] == 0:
                tot1 -= 1
            left1 += 1
        while tot2 > K - 1:
            num2[A[left2]] -= 1
            if num2[A[left2]] == 0:
                tot2 -= 1
            left2 += 1
        print(left1, left2, right)
        ret += left2 - left1
    return ret

if __name__ == "__main__":
    print(subarraysWithKDistinct(A = [1,2,1,2,3], K = 2))