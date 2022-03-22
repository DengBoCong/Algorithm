def winnerOfGame(colors: str) -> bool:
    remain = {"A": 0, "B": 0}
    left, right = 0, 0
    length = len(colors)
    while left < length and right < length:
        while right < length and colors[right] == colors[left]:
            right += 1

        remain[colors[left]] += right - left - 2 if right - left >= 3 else 0
        left = right

    return remain["A"] > remain["B"]

