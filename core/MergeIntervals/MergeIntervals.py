from typing import List


def merge(intervals: List[List[int]]) -> List[List[int]]:
    intervals.sort(key=lambda x: x[0])
    res, left, right, length = [], 0, 0, len(intervals)
    while right < length:
        end_num = intervals[left][1]
        while right < length and intervals[right][0] <= end_num:
            end_num = max(end_num, intervals[right][1])
            right += 1
        if right - 1 != left:
            res.append([min(intervals[left][0], intervals[right - 1][0]), end_num])
        else:
            res.append(intervals[left])
        left = right

    return res
