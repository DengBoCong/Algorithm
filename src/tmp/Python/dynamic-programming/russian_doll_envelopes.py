import bisect
from typing import List

def maxEnvelopes(envelopes: List[List[int]]) -> int:
    n = len(envelopes)
    if n == 0:
        return 0
    envelopes.sort(key=lambda x: (x[0], -x[1]))
    print(envelopes)
    d = []
    for envelope in envelopes:
        if not d or d[-1] < envelope[1]:
            d.append(envelope[1])
        left, right = 0, len(d) - 1
        loc = left
        while left <= right:
            mid = (left + right) // 2
            if d[mid] >= envelope[1]:
                loc = mid
                right = mid - 1
            else:
                left = mid + 1
        d[loc] = envelope[1]
    print(d)
    return len(d)


if __name__ == "__main__":
    print(maxEnvelopes([[4,5],[4,6],[6,7],[2,3],[1,1]]))