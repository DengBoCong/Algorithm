import collections

class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.size = [1] * n
        self.n = n
        self.setCount = n
    
    def findset(self, x: int) -> int:
        if self.parent[x] == x:
            return x
        self.parent[x] = self.findset(self.parent[x])
        return self.parent[x]
    
    def union(self, x: int, y: int) -> bool:
        x, y = self.findset(x), self.findset(y)
        if x == y:
            return False
        if self.size[x] < self.size[y]:
            x, y = y, x
        self.parent[y] = x
        self.size[x] += self.size[y]
        self.setCount -= 1
        return True
    
    def connected(self, x: int, y: int) -> bool:
        x, y = self.findset(x), self.findset(y)
        return x == y

class TarjanSCC:
    def __init__(self, n: int, edges: list, edgesId: list):
        self.n = n
        self.edges = edges
        self.edgesId = edgesId
        self.low = [-1] * n
        self.dfn = [-1] * n
        self.ans = list()
        self.ts = -1
    
    def getCuttingEdge(self) -> list:
        for i in range(self.n):
            if self.dfn[i] == -1:
                self.pGetCuttingEdge(i, -1)
        return self.ans
    
    def pGetCuttingEdge(self, u: int, parrentEdgeId: int):
        self.ts += 1
        self.low[u] = self.dfn[u] = self.ts
        for v, iden in zip(self.edges[u], self.edgesId[u]):
            if self.dfn[v] == -1:
                self.pGetCuttingEdge(v, iden)
                self.low[u] = min(self.low[u], self.low[v])
                if self.low[v] > self.dfn[u]:
                    self.ans.append(iden)
            elif iden != parrentEdgeId:
                self.low[u] = min(self.low[u], self.dfn[v])


def findCriticalAndPseudoCriticalEdges(n: int, edges: list) -> list:
    m = len(edges)
    for i, edge in enumerate(edges):
        edge.append(i)
    edges.sort(key=lambda x: x[2])
    uf = UnionFind(n)
    ans0 = list()
    label = [0] * m
    i = 0
    while i < m:
        w = edges[i][2]
        j = i
        while j < m and edges[j][2] == edges[i][2]:
            j += 1
        compToId = dict()
        gn = 0

        for k in range(i, j):
            x = uf.findset(edges[k][0])
            y = uf.findset(edges[k][1])
            if x != y:
                if x not in compToId:
                    compToId[x] = gn
                    gn += 1
                if y not in compToId:
                    compToId[y] = gn
                    gn += 1
            else:
                label[edges[k][3]] = -1
        gm = collections.defaultdict(list)
        gmid = collections.defaultdict(list)

        for k in range(i, j):
            x = uf.findset(edges[k][0])
            y = uf.findset(edges[k][1])
            if x != y:
                idx, idy = compToId[x], compToId[y]
                gm[idx].append(idy)
                gmid[idx].append(edges[k][3])
                gm[idy].append(idx)
                gmid[idy].append(edges[k][3])

        bridges = TarjanSCC(gn, gm, gmid).getCuttingEdge()
        
        ans0.extend(bridges)
        for iden in bridges:
            label[iden] = 1

        for k in range(i, j):
            uf.union(edges[k][0], edges[k][1])
        
        i = j
        
    ans1 = [i for i in range(m) if label[i] == 0]

    return [ans0, ans1]

if __name__ == "__main__":
    print(findCriticalAndPseudoCriticalEdges(n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]))