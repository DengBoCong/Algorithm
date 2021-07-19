import collections
from typing import List

def findShortestSubArray(nums: List[int]) -> int:
    record = 0
    remain = collections.defaultdict(list)
    for i, num in enumerate(nums):
        if num in remain:
            remain[num][0] += 1
            remain[num][2] = i
        else:
            remain[num] = [1, i, i]
        record = max(record, remain[num][0])
    
    result = 50001
    for count, start, end in remain.values():
        if count == record:
            result = min(result, end - start + 1)
    
    return result

if __name__ == "__main__":
    print(findShortestSubArray([1]))

