import collections

def findCircleNum_union_find(isConnected):
    """
    使用并查集的方法
    :type isConnected: List[List[int]]
    :rtype: int
    """
    def find(col):
        if province[col] != col:
            province[col] = find(province[col])
        return province[col]

    def union(row, col):
        province[find(row)] = find(col)

    n = len(isConnected)
    province = list(range(n))

    for i in range(n):
        for j in range(i + 1, n):
            if isConnected[i][j] == 1:
                union(i, j)
    
    count = 0
    for i in range(n):
        if province[i] == i:
            count += 1
    
    return count

def findCircleNum_dfs(isConnected):
    """
    使用并查集的方法
    :type isConnected: List[List[int]]
    :rtype: int
    """
    def dfs(i):
        for j in range(n):
            if isConnected[i][j] == 1 and j not in visited:
                visited.add(j)
                dfs(j)

    n = len(isConnected)
    visited = set()
    count = 0

    for i in range(n):
        if i not in visited:
            dfs(i)
            count += 1
    
    return count

def findCircleNum_bfs(isConnected):
    """
    使用并查集的方法
    :type isConnected: List[List[int]]
    :rtype: int
    """
    n = len(isConnected)
    visited = set()
    count = 0

    for i in range(n):
        if i not in visited:
            Q = collections.deque([i])
            while Q:
                j = Q.popleft()
                visited.add(j)
                for k in range(n):
                    if isConnected[j][k] == 1 and k not in visited:
                        Q.append(k)
            count += 1
    
    return count

if __name__ == "__main__":
    print(findCircleNum_bfs([[1,0,0],[0,1,0],[0,0,1]]))
