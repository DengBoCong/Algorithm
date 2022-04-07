from typing import List

def findMinHeightTrees(n: int, edges: List[List[int]]) -> List[int]:
    if n == 1:
        return [0]
    deg = [0] * n
    graph = [[] for _ in range(n)]
    for edge in edges:
        graph[edge[0]].append(edge[1])
        graph[edge[1]].append(edge[0])
        deg[edge[0]] += 1
        deg[edge[1]] += 1

    queue = [i for i in range(n) if deg[i] == 1]
    remain_num = n
    while remain_num > 2:
        remain_num -= len(queue)
        temp = queue
        queue = []
        for item in temp:
            for node in graph[item]:
                deg[node] -= 1
                if deg[node] == 1:
                    queue.append(node)
    return queue




