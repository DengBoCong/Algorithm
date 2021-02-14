from typing import List

def find(parent: List[int], index: int):
    if index != parent[index]:
        parent[index] = find(parent, parent[index])
    return parent[index]

def union(parent: List[int], index1: int, index2: int):
    parent[find(parent, index2)] = find(parent, index1)


def minSwapsCouples(row: List[int]) -> int:
    n = len(row)
    tot = n // 2
    f = list(range(tot))

    for i in range(0, n, 2):
        l = row[i] // 2
        r = row[i + 1] // 2
        union(f, l, r)
    
    remain = {}
    for i in range(tot):
        fx = find(f, i)
        remain[fx] = remain.get(fx, 0) + 1
    
    ret = 0
    for item in remain.items():
        ret += item[1] - 1
    
    return ret

if __name__ == "__main__":
    print(minSwapsCouples([3, 2, 0, 1]))