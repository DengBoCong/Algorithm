from typing import List


def longestConsecutive(nums: List[int]) -> int:
    nums_map, res = {num: False for num in nums}, 0
    for num in nums:
        if nums_map[num]:
            continue
        count, temp = 0, num
        while temp in nums_map:
            count += 1
            nums_map[temp] = True
            temp += 1
        temp = num - 1
        while temp in nums_map:
            count += 1
            nums_map[temp] = True
            temp -= 1
        res = max(res, count)

    return res


