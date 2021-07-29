def checkSubarraySum_violence(nums: list, k: int) -> bool:
    length = len(nums)
    if length < 2:
        return False

    for i in range(1, length):
        total = nums[i]
        for j in range(i - 1, -1, -1):
            total += nums[j]
            if k == 0 and total == 0:
                return True
            elif k != 0 and total % k == 0:
                return True

    return False


def checkSubarraySum_prefix(nums: list, k: int) -> bool:
    pre = 0
    mp = {0: -1}
    for i in range(len(nums)):
        pre += nums[i]
        if k != 0:
            pre %= k
        if i - mp.get(pre, i) > 1:
            return True
        
        if mp.get(pre, -2) == -2:
            mp[pre] = i

    return False


if __name__ == "__main__":
    print(checkSubarraySum_prefix(nums=[0,0], k = 0))
