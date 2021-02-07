from typing import List

def checkPossibility(nums: List[int]) -> bool:
    n = len(nums)
    count = 0
    for i in range(n - 1):
        x, y = nums[i], nums[i + 1]
        if x > y:
            count += 1
            if count > 1:
                return False
            if i > 0 and y < nums[i - 1]:
                nums[i + 1] = x

    return True

if __name__ == "__main__":
    print(checkPossibility([4,2,3]))

