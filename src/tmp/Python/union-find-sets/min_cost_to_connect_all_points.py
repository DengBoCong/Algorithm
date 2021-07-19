import sys


def minCostConnectPoints_krushal(points: list) -> int:
    def find(index: int) -> int:
        if parent[index] != index:
            parent[index] = find(parent[index])
        return parent[index]

    def union(x: int, y: int) -> bool:
        root_x, root_y = find(x), find(y)
        if root_x == root_y:
            return False

        if rank[root_x] < rank[root_y]:
            root_x, root_y = root_y, root_x

        rank[root_x] += rank[root_y]
        parent[root_y] = root_x
        return True

    dist = lambda x, y: abs(points[x][0] - points[y][0]) + abs(points[x][1] - points[y][1])
    length = len(points)
    rank = [1] * length
    parent = list(range(length))
    edges = list()

    for i in range(length):
        for j in range(i + 1, length):
            edges.append((dist(i, j), i, j))

    edges.sort()

    ret, num = 0, 1
    for weight, x, y in edges:
        if union(x, y):
            ret += weight
            num += 1
            if num == length:
                break

    return ret


def minCostConnectPoints_greed(points: list) -> int:
    n, ans = len(points), 0
    seen = set()
    dis = [float('inf')] * n
    cur = 0
    
    for i in range(n-1):
        x, y = points[cur]
        seen.add(cur)
        for j, (nx, ny) in enumerate(points):
            if j in seen: continue
            dis[j] = min(dis[j], abs(nx-x)+abs(ny-y))
        s, cur = min((d, j) for j, d in enumerate(dis))
        dis[cur] = float('inf')
        ans += s
        
    return ans


if __name__ == "__main__":
    print(minCostConnectPoints_greed(
        [[0, 0], [2, 2], [3, 10], [5, 2], [7, 0]]))
