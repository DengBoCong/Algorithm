import collections


def find(parent: list, index: int) -> int:
    if index != parent[index]:
        parent[index] = find(parent, parent[index])
    return parent[index]

def union(parent: list, index1: int, index2: int) -> None:
    parent[find(parent, index2)] = find(parent, index1)

def swimInWater_union_find(grid: list) -> int:
    n = len(grid)
    parent = list(range(n * n))
    edges = []
    for i in range(n):
        for j in range(n):
            edges.append((grid[i][j], i, j))
    
    result = 0
    dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    for val, nx, ny in sorted(edges):
        result = val
        for row, col in dirs:
            x, y = nx + row, ny + col
            if x >= 0 and x < n and y >= 0 and y < n and grid[nx][ny] >= grid[x][y]:
                union(parent, nx * n + ny, x * n + y)
            if find(parent, (n - 1) * n + n - 1) == find(parent, 0):
                return result 
    return result

def swimInWater_binary_bfs(grid: list) -> int:
    n = len(grid)
    result = 0
    left, right, result = grid[0][0], n * n - 1, 0
    dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    while left <= right:
        mid = (left + right) // 2
        q = collections.deque()
        seen = {0: True}
        q.append((0, 0))
        while q:
            nx, ny = q.popleft()
            for row, col in dirs:
                x, y = nx + row, ny + col
                if x >= 0 and x < n and y >= 0 and y < n and not seen.get(x * n + y, False) and grid[x][y] <= mid:
                    q.append((x, y))
                    seen[x * n + y] = True
        if seen.get((n - 1) * n + n - 1, False):
            result = mid
            right = mid - 1
        else:
            left = mid + 1
    return result

def dfs(seen: dict, grid: list, x: int, y: int, n: int, mid: int) -> None:
    for nx, ny in [(x - 1, y), (x + 1, y), (x, y + 1), (x, y - 1)]:
        if 0 <= nx < n and 0 <= ny < n and not seen.get(nx * n + ny, False) and grid[nx][ny] <= mid:
            seen[nx * n + ny] = True
            dfs(seen, grid, nx, ny, n, mid)

def swimInWater_binary_dfs(grid: list) -> int:
    n = len(grid)
    left, right, result = grid[0][0], n * n - 1, 0
    while left <= right:
        seen = {0: True}
        mid = (left + right) // 2
        dfs(seen, grid, 0, 0, n, mid)
        if seen.get((n - 1) * n + n - 1, False):
            right = mid - 1
            result = mid
        else:
            left = mid + 1
    
    return result


if __name__ == "__main__":
    print(swimInWater_binary_dfs([[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]))