from typing import List


def reversePairs(nums: List[int]) -> int:
    res = 0
    if not nums:
        return 0

    def merge(left, right):
        nonlocal res
        if left == right:
            return [nums[left]]
        mid = (left + right) // 2
        left_nums = merge(left, mid)
        right_nums = merge(mid + 1, right)

        point1, point2, merge_num, len1, len2 = 0, 0, [], len(left_nums), len(right_nums)
        while point1 < len1 and point2 < len2:
            if left_nums[point1] <= right_nums[point2]:
                merge_num.append(left_nums[point1])
                point1 += 1
                res += point2
            else:
                merge_num.append(right_nums[point2])
                point2 += 1
        while point1 < len1:
            res += len2
            merge_num.append(left_nums[point1])
            point1 += 1
        while point2 < len2:
            merge_num.append(right_nums[point2])
            point2 += 1

        return merge_num

    merge(0, len(nums) - 1)
    return res

if __name__ == '__main__':
    print(reversePairs([7,5,6,4,5,6,4]))

