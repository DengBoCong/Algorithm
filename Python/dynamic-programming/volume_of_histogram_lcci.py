from typing import *

def trap(height: List[int]) -> int:
    length = len(height)
    if length == 0:
        return 0

    left, right = [0], [0]
    for i in range(1, length):
        left.append(max(height[i - 1], left[i - 1]))
        right.append(max(height[length - i], right[i - 1]))
    
    total = 0
    for i in range(1, length - 1):
        min_val = min(left[i], right[length - i - 1])
        if height[i] < min_val:
            total += min_val - height[i]
    
    return total

def trap1(height: List[int]) -> int:
    ans = 0
    left, right = 0, len(height) - 1
    leftMax = rightMax = 0

    while left < right:
        leftMax = max(leftMax, height[left])
        rightMax = max(rightMax, height[right])
        if height[left] < height[right]:
            ans += leftMax - height[left]
            left += 1
        else:
            ans += rightMax - height[right]
            right -= 1
    
    return ans

if __name__ == "__main__":
    print(trap([0,1,0,2,1,0,1,3,2,1,2,1]))
