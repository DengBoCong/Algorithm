from typing import List


def maxArea(height: List[int]) -> int:
    left, right = 0, len(height) - 1
    res = 0
    while left < right:
        res = max(res, (right - left) * min(height[left], height[right]))
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return res



