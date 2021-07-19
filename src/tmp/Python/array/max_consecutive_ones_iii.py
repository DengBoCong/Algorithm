def longestOnes(A: list, K: int) -> int:
    left, right, maxn = 0, 0, 0
    while right < len(A):
        if A[right] == 1:
            maxn += 1
        if right - left + 1 - maxn > K:
            if A[left] == 1:
                maxn -= 1
            left += 1
        right += 1
    
    return right - left

if __name__ == "__main__":
    print(longestOnes(A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3))