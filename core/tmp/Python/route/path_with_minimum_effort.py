import collections
import heapq


def minimumEffortPath_binary_bfs(heights: list) -> int:
    m, n = len(heights), len(heights[0])
    left, right, ans = 0, 10**6 - 1, 0

    while left <= right:
        mid = (left + right) // 2
        q = collections.deque([(0, 0)])
        seen = {(0, 0)}

        while q:
            x, y = q.popleft()
            for nx, ny in [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)]:
                if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in seen and abs(heights[x][y] - heights[nx][ny]) <= mid:
                    q.append((nx, ny))
                    seen.add((nx, ny))

        if (m - 1, n - 1) in seen:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1
    return ans


def dfs(seen: list, row: int, col: int, mid: int, row_len, col_len, heights):
        seen.append((row, col))
        for nx, ny in [(row - 1, col), (row + 1, col), (row, col + 1), (row, col - 1)]:
            if 0 <= nx < row_len and 0 <= ny < col_len and abs(heights[row][col] - heights[nx][ny]) <= mid and (nx, ny) not in seen:
                seen.append((nx, ny))
                dfs(seen, nx, ny, mid, row_len, col_len, heights)

def minimumEffortPath_binary_dfs(heights: list) -> int:
    row_len, col_len = len(heights), len(heights[0])
    left, right, result = 0, 10**6 - 1, 0
    while left <= right:
        seen = []
        mid = (left + right) // 2
        dfs(seen, 0, 0, mid, row_len, col_len, heights)

        if (row_len - 1, col_len - 1) in seen:
            result = mid
            right = mid - 1
        else:
            left = mid + 1
        
        print(seen)

    return result

def find(parent: list, index: int) -> int:
    if index != parent[index]:
        parent[index] = find(parent, parent[index])
    return parent[index]

def union(parent: list, index1: int, index2: int) -> None:
    parent[find(parent, index2)] = find(parent, index1)

def minimumEffortPath_union_find(heights: list) -> int:
    row, col = len(heights), len(heights[0])
    parent = list(range(row * col))

    edges = []
    for i in range(row):
        for j in range(col):
            if i != row - 1:
                edges.append((abs(heights[i][j] - heights[i + 1][j]), i * col + j, (i + 1) * col + j))
            if j != col - 1:
                edges.append((abs(heights[i][j] - heights[i][j + 1]), i * col + j, i * col + j + 1))
    
    result = 0
    for weight, x, y in sorted(edges):
        union(parent, x, y)
        result = weight
        if find(parent, 0) == find(parent, (row - 1) * col + (col - 1)):
            break
    
    return result

def minimumEffortPath_dijkstra(heights: list) -> int:
    m, n = len(heights), len(heights[0])
    q = [(0, 0, 0)]
    dist = [0] + [float("inf")] * (m * n - 1)
    seen = set()

    while q:
        d, x, y = heapq.heappop(q)
        iden = x * n + y
        if iden in seen:
            continue
        if (x, y) == (m - 1, n - 1):
            break

        seen.add(iden)
        for nx, ny in [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)]:
            if 0 <= nx < m and 0 <= ny < n and max(d, abs(heights[x][y] - heights[nx][ny])) <= dist[nx * n + ny]:
                dist[nx * n + ny] = max(d, abs(heights[x][y] - heights[nx][ny]))
                heapq.heappush(q, (dist[nx * n + ny], nx, ny))
    
    return dist[m * n - 1]


if __name__ == "__main__":
    print(minimumEffortPath_dijkstra([[4,3,4,10,5,5,9,2],[10,8,2,10,9,7,5,6],[5,8,10,10,10,7,4,2],[5,1,3,1,1,3,1,9],[6,4,10,6,10,9,4,6]]))
