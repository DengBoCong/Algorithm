from typing import List
from collections import defaultdict

def restoreArray(adjacentPairs: List[List[int]]) -> List[int]:
    remain = defaultdict(list)
    for u, v in adjacentPairs:
        remain[u].append(v)
        remain[v].append(u)
    
    result = []
    seen = set()
    for key, value in remain.items():
        if len(value) == 1:
            result.append(key)
            result.append(value[0])
            seen.add(key)
            seen.add(value[0])
            break
    
    length = len(adjacentPairs) + 1
    count = 2
    while count < length:
        for num in remain[result[-1]]:
            if num not in seen:
                result.append(num)
                seen.add(num)
                break
            count += 1
    
    return result

if __name__ == "__main__":
    print(restoreArray([[100000,-100000]]))
        


    
