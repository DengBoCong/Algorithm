import collections
from typing import *

def numRabbits(answers: List[int]) -> int:
    count = collections.Counter(answers)
    ans = sum((x + y) // (y + 1) * (y + 1) for y, x in count.items())
    return ans