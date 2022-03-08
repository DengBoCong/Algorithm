from typing import List


def platesBetweenCandles(s: str, queries: List[List[int]]) -> List[int]:
    prefix_list, left_pos, right_pos = [], [], []
    count, flag, prefix_pos = 0, -1, 0
    for index, ch in enumerate(s):
        if flag != -1 and ch == "*":
            count += 1

        if ch == "|":
            flag = count
            prefix_pos = index

        left_pos.append(prefix_pos)
        prefix_list.append(0 if flag == -1 else flag)

    prefix_pos = len(s) - 1
    for index in range(len(s) - 1, -1, -1):
        if s[index] == "|":
            prefix_pos = index
        right_pos.insert(0, prefix_pos)

    res = []
    for left, right in queries:
        res.append(
            prefix_list[left_pos[right]] - prefix_list[right_pos[left]] if left_pos[right] > right_pos[left] else 0)

    return res


if __name__ == '__main__':
    print(platesBetweenCandles(s="**|**|***|", queries=[[2, 5], [5, 9]]))
