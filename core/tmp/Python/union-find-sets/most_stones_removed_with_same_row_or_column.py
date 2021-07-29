def removeStones(stones: list) -> int:
    def find(count: int, index: int) -> int:
        if parent.get(index, -1) == -1:
            parent[index] = index
            count += 1
        if index != parent.get(index):
            parent[index], count = find(count, parent[index])
        return parent[index], count

    def union(count: int, index1: int, index2: int):
        rootX, count = find(count, index1)
        rootY, count = find(count, index2)
        if rootX == rootY:
            return count
        parent[rootX] = rootY
        count -= 1
        return count

    if len(stones) <= 1:
        return 0

    parent = {}
    
    count = 0
    for stone in stones:
        count = union(count, stone[0] + 10001, stone[1])
    return len(stones) - count


if __name__ == "__main__":
    print(removeStones([[0,0],[0,2],[1,1],[2,0],[2,2]]))
