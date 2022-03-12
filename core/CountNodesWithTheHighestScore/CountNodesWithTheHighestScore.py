from typing import List


def countHighestScoreNodes(parents: List[int]) -> int:
    n = len(parents)
    children = [[] for _ in range(n)]
    for index in range(1, n):
        children[parents[index]].append(index)

    max_scores, count = 0, 0

    def dfs(root):
        size, scores = n - 1, 1
        for child in children[root]:
            sz = dfs(child)
            scores *= sz
            size -= sz
        if root != 0:
            scores *= size
        nonlocal max_scores, count
        if scores > max_scores:
            count = 1
            max_scores = scores
        elif scores == max_scores:
            count += 1

        return n - size

    dfs(0)
    return count


if __name__ == '__main__':
    print(countHighestScoreNodes([-1, 2, 0, 2, 0]))
