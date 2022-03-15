from typing import List


def countMaxOrSubsets(nums: List[int]) -> int:
    length = len(nums)
    count, max_or = 0, 0

    def dfs(start, cur_or):
        nonlocal count, max_or
        temp_or = cur_or
        for i in range(start, length):
            cur_or = temp_or | nums[i]
            if cur_or > max_or:
                count = 1
                max_or = cur_or
            elif cur_or == max_or:
                count += 1
            dfs(i + 1, cur_or)

    dfs(0, 0)
    return count


if __name__ == '__main__':
    print(countMaxOrSubsets([3, 2, 1, 5]))
