def findMaxConsecutiveOnes(nums: list) -> int:
    count, result = 0, 0
    for num in nums:
        if num == 1:
            count += 1
        else:
            result = max(result, count)
            count = 0
    
    return max(result, count)

if __name__ == "__main__":
    print(findMaxConsecutiveOnes([1,1,0,1,1,1]))
