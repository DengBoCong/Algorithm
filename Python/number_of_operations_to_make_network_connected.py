def makeConnected(n: int, connections: list) -> int:
    def find(index: int) -> int:
        if parent[index] != index:
            parent[index] = find(parent[index])
        return parent[index]
    
    def union(index1: int, index2: int):
        parent[find(index2)] = find(index1)
    
    parent = list(range(n))
    network= n
    count = 0
    for index1, index2 in connections:
        root_X = find(index1)
        root_Y = find(index2)
        if root_X != root_Y:
            union(index1, index2)
            network -= 1
        else:
            count += 1
    
    if count >= network - 1:
        return network - 1
    else:
        return -1

if __name__ == "__main__":
    print(makeConnected(n = 4, connections = [[0,1],[0,2],[1,2]]))