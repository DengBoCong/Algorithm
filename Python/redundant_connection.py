def findRedundantConnection(edges: list) -> list:
    def find(point: int) -> int:
        if point != store[point]:
            store[point] = find(store[point])
        return store[point]
    
    def union(start: int, end: int):
        store[find(start)] = find(end)
    
    length = len(edges)
    store = list(range(length + 1))
    for edge in edges:
        if find(edge[0]) == find(edge[1]):
            return edge
        union(edge[0], edge[1])
    
    return []

if __name__ == "__main__":
    print(findRedundantConnection([[1,2], [1,3], [2,3]]))# [1,2], [2,3], [3,4], [1,4], [1,5]