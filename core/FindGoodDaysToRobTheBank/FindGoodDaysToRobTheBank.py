from typing import List


def goodDaysToRobBank(security: List[int], time: int) -> List[int]:
    length = len(security)
    left, right = [0] * length, [0] * length
    for cur in range(1, length - 1):
        if security[cur] <= security[cur - 1]:
            left[cur] = left[cur - 1] + 1
        if security[length - 1 - cur] <= security[length - cur]:
            right[length - 1 - cur] = right[length - cur] + 1

    return [index for index, (li, ri) in enumerate(zip(left, right)) if li >= time and ri >= time]


if __name__ == '__main__':
    print(goodDaysToRobBank([1], 5))
