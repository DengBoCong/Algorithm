from typing import List
from collections import deque


def duplicateZeros(arr: List[int]) -> None:
    queue, length = deque(), len(arr)

    for index in range(length):
        if arr[index] == 0:
            queue.append(0)
        queue.append(arr[index])
        arr[index] = queue.popleft()
