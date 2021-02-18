from typing import List

def minKBitFlips(A: List[int], K: int) -> int:
    n = len(A)
    diff = [0] * (n + 1)
    ans, revCnt = 0, 0
    for i in range(n):
        revCnt += diff[i]
        if (A[i] + revCnt) % 2 == 0:
            if i + K > n:
                return -1
            ans += 1
            revCnt += 1
            diff[i + K] -= 1
            print(diff)
    
    return ans

def minKBitFlipsSlide(A: List[int], K: int) -> int:
    n = len(A)
    ans, revCnt = 0, 0
    for i in range(n):
        if i >= K and A[i - K] > 1:
            revCnt ^= 1
            A[i - K] -= 2
        if A[i] == revCnt:
            if i + K > n:
                return -1
            ans += 1
            revCnt ^= 1
            A[i] += 2
    return ans

if __name__ == "__main__":
    print(minKBitFlipsSlide(A = [0,0,0,1,0,1,1,0], K = 3))