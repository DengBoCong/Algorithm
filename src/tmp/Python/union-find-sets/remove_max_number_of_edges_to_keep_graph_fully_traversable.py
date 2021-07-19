class UnionFind():
    def __init__(self, parent: list) -> None:
        self.parent = parent

    def find(self, index: int) -> int:
        if index != self.parent[index]:
            self.parent[index] = self.find(self.parent[index])
        return self.parent[index]

    def union(self, index1: int, index2) -> None:
        self.parent[self.find(index2)] = self.find(index1)


def maxNumEdgesToRemove(n: int, edges: list) -> int:
    parent = list(range(n+1))
    alice = []
    bob = []
    count = 0
    flag = 0

    type1 = UnionFind(parent)
    for edge in edges:
        if edge[0] == 1:
            alice.append(edge)
        elif edge[0] == 2:
            bob.append(edge)
        else:
            u = type1.find(edge[1])
            v = type1.find(edge[2])
            if u == v:
                count += 1
            else:
                type1.union(u, v)
                flag += 1

    temp = flag
    type2 = UnionFind(parent.copy())
    type3 = UnionFind(parent.copy())
    for edge in alice:
        u = type2.find(edge[1])
        v = type2.find(edge[2])
        if u == v:
            count += 1
        else:
            type2.union(u, v)
            temp += 1

    if temp < n - 1:
        return -1
    temp = flag
    for edge in bob:
        u = type3.find(edge[1])
        v = type3.find(edge[2])
        if u == v:
            count += 1
        else:
            type3.union(u, v)
            temp += 1

    if temp < n - 1:
        return -1

    return count


if __name__ == "__main__":
    print(maxNumEdgesToRemove(n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]))
