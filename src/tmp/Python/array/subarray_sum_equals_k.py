def subarraySum(nums: list, k: int) -> int:
    count, pre = 0, 0
    mp = {}
    mp[0] = 1
    for i in range(len(nums)):
        pre += nums[i]
        count += mp.get(pre - k, 0)
        mp[pre] = mp.get(pre, 0) + 1
    return count

if __name__ == "__main__":
    print(subarraySum(nums = [1,1,1], k = 2))