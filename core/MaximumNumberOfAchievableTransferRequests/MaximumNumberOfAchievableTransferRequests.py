from typing import List


def maximumRequests(n: int, requests: List[List[int]]) -> int:
    floor = {i: 0 for i in range(n)}
    length = len(requests)
    max_req = 0

    def dfs(req_list, start):
        nonlocal max_req, floor
        for index in range(start, length):
            req_list.append(index)
            floor[requests[index][0]] -= 1
            floor[requests[index][1]] += 1
            if sum([val for val in floor.values() if val > 0]) == 0:
                max_req = max(max_req, len(req_list))
            dfs(req_list, index + 1)
            req_list.pop()
            floor[requests[index][0]] += 1
            floor[requests[index][1]] -= 1

    dfs([], 0)
    return max_req


if __name__ == '__main__':
    print(maximumRequests(n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]))
