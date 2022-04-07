def rotateString(s: str, goal: str) -> bool:
    if len(s) != len(goal):
        return False
    length = len(s)
    for index in range(length):
        left, right = index, 0
        while right < length:
            if s[left] != goal[right]:
                break
            left = (left + 1) % length
            right += 1

        if right == length:
            return True

    return False




