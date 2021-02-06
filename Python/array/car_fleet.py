from typing import List

def carFleet(target: int, position: List[int], speed: List[int]) -> int:
    if not position or not speed:
        return 0

    remain = {(position[0], (target - position[0]) / speed[0])}
    n = len(position)
    for i in range(1, n):
        remain.add((position[i], (target - position[i]) / speed[i]))
    
    count = n
    remain = sorted(remain)
    flag = remain[-1][1]
    for i in range(1, n):
        if remain[n - 1 - i][1] <= flag:
            count -= 1
        flag = max(flag, remain[n - 1 - i][1])

    return count 


if __name__ == "__main__":
    print(carFleet(target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]))