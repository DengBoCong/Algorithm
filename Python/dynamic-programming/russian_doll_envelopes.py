from typing import List

def maxEnvelopes(envelopes: List[List[int]]) -> int:
    envelopes = sorted(envelopes)
    imax, left, right, length = 0, 0, 1, len(envelopes)

    if length <= 1:
        return length

    while right < length:
        if envelopes[right][1] <= envelopes[right - 1][1]:
            left = right
        right += 1
        imax = max(imax, right - left)
    
    return imax


if __name__ == "__main__":
    print(maxEnvelopes([[5,4],[2,3],[6,4],[6,7]]))