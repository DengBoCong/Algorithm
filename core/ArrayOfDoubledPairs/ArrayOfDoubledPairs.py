from typing import List
from collections import Counter


def canReorderDoubled(arr: List[int]) -> bool:
    counter = Counter(arr)
    for num in sorted(counter, key=lambda k: abs(k)):
        if counter[num * 2] < counter[num]:
            return False
        counter[num * 2] -= counter[num]

    return True

if __name__ == '__main__':
    print(canReorderDoubled([-1,2]))
