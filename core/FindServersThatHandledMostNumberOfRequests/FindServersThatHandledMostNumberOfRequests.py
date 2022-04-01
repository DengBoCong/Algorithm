from typing import List
from collections import Counter
import heapq

def busiestServers(k: int, arrival: List[int], load: List[int]) -> List[int]:
    available = list(range(k))
    busy = []
    requests = [0] * k
    for i, (start, t) in enumerate(zip(arrival, load)):
        while busy and busy[0][0] <= start:
            _, id = heapq.heappop(busy)
            heapq.heappush(available, i + (id - i) % k)
        if available:
            id = heapq.heappop(available) % k
            requests[id] += 1
            heapq.heappush(busy, (start + t, id))
    res = max(requests)
    return [i for i, req in enumerate(requests) if req == res]


if __name__ == '__main__':
    print(busiestServers(k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3] ))

