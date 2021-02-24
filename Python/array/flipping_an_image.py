from typing import List

def flipAndInvertImage(A: List[List[int]]) -> List[List[int]]:
    row, col = len(A), len(A[0])
    for i in range(row):
        left, right = 0, col- 1
        while left <= right:
            if left == right:
                A[i][left] ^= 1
            elif A[i][left] == A[i][right]:
                A[i][left] ^= 1
                A[i][right] ^= 1
            left += 1
            right -= 1
    
    return A

if __name__ == "__main__":
    print(flipAndInvertImage([[1,1,0],[1,0,1],[0,0,0]]))