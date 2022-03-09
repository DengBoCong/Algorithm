from typing import List

def bestRotation(nums: List[int]) -> int:
    diffs = [0] * len(nums)
    for index, num in enumerate(nums):
        low = (index + 1) % len(nums)
        high = (index - num + len(nums) + 1) % len(nums)
        if high < low:
            diffs[0] += 1

        diffs[low] += 1
        diffs[high] -= 1

    count, res = 0, [0, 0]
    for index, num in enumerate(diffs):
        count += num
        if count > res[1]:
            res[0] = index
            res[1] = count

    return res[0]

if __name__ == '__main__':
    print(bestRotation([1,3,0,2,4]))
