def pivotIndex(nums: list) -> int:
    if not nums:
        return -1

    total = 0
    for num in nums:
        total += num
    
    precent = 0
    for i in range(len(nums)):
        if precent == total - nums[i] - precent:
            return i
        precent += nums[i]
    
    return -1

if __name__ == "__main__":
    print(pivotIndex([1, 2, 3]))