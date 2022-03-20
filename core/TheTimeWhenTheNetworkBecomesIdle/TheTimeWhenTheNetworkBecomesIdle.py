from typing import List
from collections import deque


def networkBecomesIdle(edges: List[List[int]], patience: List[int]) -> int:
    length = len(patience)
    graph = [[] for _ in range(length)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    queue = deque([0])
    visited = [False] * length
    visited[0] = True
    res, level = 0, 1
    while queue:
        for _ in range(len(queue)):
            for v in graph[queue.popleft()]:
                if visited[v]:
                    continue
                visited[v] = True
                queue.append(v)

                res = max(res, 2 * level + 1 + (level * 2 - 1) // patience[v] * patience[v])

        level += 1

    return res


if __name__ == '__main__':
    print(networkBecomesIdle(edges=[[0, 1], [0, 2], [1, 2]], patience=[0, 10, 10]))
