def findLengthOfLCIS(nums: list) -> int:
    if not nums:
        return 0

    count = 1
    result = 0
    for i in range(1, len(nums)):
        if nums[i] > nums[i - 1]:
            count += 1
        else:
            result = max(result, count)
            count = 1
    
    return max(result, count)

if __name__ == "__main__":
    print(findLengthOfLCIS([]))