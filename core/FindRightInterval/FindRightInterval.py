from typing import List


def findRightInterval(intervals: List[List[int]]) -> List[int]:
    for i, interval in enumerate(intervals):
        interval.append(i)
    intervals.sort()

    def search(left, right, target):
        while left < right:
            mid = (left + right) // 2
            if intervals[mid][0] == target:
                return intervals[mid][2]
            elif intervals[mid][0] > target:
                right = mid
            else:
                left = mid + 1
        return intervals[left][2] if intervals[left][0] >= target else -1

    length = len(intervals)
    ans = [-1] * length
    for index in range(length):
        ans[intervals[index][2]] = search(0, length - 1, intervals[index][1])
    return ans


if __name__ == '__main__':
    print(findRightInterval([[3,4],[2,3],[1,2]]))

