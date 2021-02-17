from typing import List

def matrixReshape(nums: List[List[int]], r: int, c: int) -> List[List[int]]:
    row = len(nums)
    col = len(nums[0])
    if row * col != r * c:
        return nums
    
    result = list()
    left, right = 0, 0
    for i in range(r):
        remain = list()
        for j in range(c):
            remain.append(nums[left][right])
            if right == col - 1:
                left += 1
                right = 0
            else:
                right += 1
        result.append(remain)

    return result

if __name__ == "__main__":
    print(matrixReshape(nums = [[1,2],[3,4]], r = 4, c = 1))
