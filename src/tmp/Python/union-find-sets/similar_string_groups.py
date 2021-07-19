def find(parent: list, index: int) -> int:
    if index != parent[index]:
        parent[index] = find(parent, parent[index])
    return parent[index]


def union(parent: list, index1: int, index2: int) -> None:
    parent[find(parent, index2)] = find(parent, index1)


def check(a: str, b: str) -> bool:
    if len(a) != len(b):
        return False
    num = 0
    for x, y in zip(a, b):
        if x != y:
            num += 1
        if num > 2:
            return False

    return num == 2 or num == 0


def numSimilarGroups(strs: list) -> int:
    n = len(strs)
    parent = list(range(n))
    for i in range(n):
        for j in range(i + 1, n):
            if check(strs[i], strs[j]):
                union(parent, i, j)
    
    result = set()
    for i in range(n):
        result.add(find(parent, i))
    
    return len(result)

if __name__ == "__main__":
    print(numSimilarGroups(["omv","ovm"]))
