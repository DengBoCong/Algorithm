from typing import List


def canFinish(numCourses: int, prerequisites: List[List[int]]) -> bool:
    graph, count = {}, [0] * numCourses
    for end, start in prerequisites:
        count[end] += 1
        if start not in graph:
            graph[start] = []
        graph[start].append(end)

    queue = []
    for i in range(numCourses):
        if count[i] == 0:
            queue.append(i)

    while queue:
        item = queue.pop()
        if item in graph:
            for node in graph[item]:
                count[node] -= 1
                if count[node] == 0:
                    queue.append(node)

    for i in range(numCourses):
        if count[i] != 0:
            return False

    return True


