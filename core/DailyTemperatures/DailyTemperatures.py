from typing import List


def dailyTemperatures(temperatures: List[int]) -> List[int]:
    length = len(temperatures)
    res = [0] * length

    stack = []
    for index, temperature in enumerate(temperatures):
        while stack and stack[-1][1] < temperature:
            res[stack[-1][0]] = index - stack[-1][0]
            stack.pop()
        stack.append((index, temperature))

    return res


if __name__ == '__main__':
    print(dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))
