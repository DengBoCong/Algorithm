from typing import Deque


def reverseLeftWords(s: str, n: int) -> str:
    queue = Deque(s)
    for i in range(n):
        queue.append(queue.popleft())
    
    return "".join(list(queue))

if __name__ == "__main__":
    print(reverseLeftWords(s = "abcdefg", n = 2))