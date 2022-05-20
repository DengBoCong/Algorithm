from typing import List


def rob(nums: List[int]) -> int:
    res, length = 0, len(nums)
    if length == 1:
        return nums[0]

    def get_max(start, end):
        pre_pre_house, pre_house = 0, 0
        for index in range(start, end):
            cur = max(pre_pre_house + nums[index], pre_house)
            pre_pre_house = pre_house
            pre_house = cur
        return pre_house

    res = max(res, get_max(0, length - 1))
    res = max(res, get_max(1, length))

    return res
