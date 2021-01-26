def regionsBySlashes(grid: list) -> int:
    def find(index: int) -> int:
        if index != parent[index]:
            parent[index] = find(parent[index])
        
        return parent[index]
    
    def union(index1: int, index2: int) -> None:
        parent[find(index2)] = find(index1)


    length = len(grid)
    parent = list(range(length * length * 4))

    for i in range(length):
        for j in range(length):
            idx = i * length + j
            if i < length - 1:
                bottom = idx + length
                union(idx * 4 + 2, bottom * 4)
            if j < length - 1:
                right = idx + 1
                union(right * 4 + 3, idx * 4 + 1)
            
            if grid[i][j] == "/":
                union(idx * 4, idx * 4 + 3)
                union(idx * 4 + 1, idx * 4 + 2)
            elif grid[i][j] == "\\":
                union(idx * 4, idx * 4 + 1)
                union(idx * 4 + 2, idx * 4 + 3)
            else:
                union(idx * 4, idx * 4 + 1)
                union(idx * 4 + 1, idx * 4 + 2)
                union(idx * 4 + 2, idx * 4 + 3)
    
    result = set()
    for i in range(length * length * 4):
        result.add(find(i))
    
    return len(result)

if __name__ == "__main__":
    print(regionsBySlashes([
  " /",
  "/ "
]))