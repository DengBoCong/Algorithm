from typing import List

# def numberOfGoodSubsets(nums: List[int]) -> int:

i = 2
x = 100
while i ** 2 <= x:
    if x % i == 0:
        print(x // i)
        break

    x += 1
