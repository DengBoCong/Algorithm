def findRedundantDirectedConnection(edges: list) -> list:
    def find(index: int) -> int:
        if ancestor[index] != index:
            ancestor[index] = find(ancestor[index])
        return ancestor[index]

    def union(index1: int, index2: int):
        ancestor[find(index1)] = find(index2)

    nodes_count = len(edges)
    ancestor = list(range(nodes_count + 1))
    parent = list(range(nodes_count + 1))
    conflict = -1
    cycle = -1
    for i, (node1, node2) in enumerate(edges):
        if parent[node2] != node2:
            conflict = i
        else:
            parent[node2] = node1
            if find(node1) == find(node2):
                cycle = i
            else:
                union(node1, node2)
    if conflict < 0:
        return [edges[cycle][0], edges[cycle][1]]
    else:
        conflict_edge = edges[conflict]
        if cycle >= 0:
            return [parent[conflict_edge[1]], conflict_edge[1]]
        else:
            return [conflict_edge[0], conflict_edge[1]]

if __name__ == "__main__":
    print(findRedundantDirectedConnection([[1,2], [2,3], [3,4], [4,1], [1,5]]))