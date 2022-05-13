def oneEditAway(first: str, second: str) -> bool:
    if first == "" or second == "":
        return (first == "" and len(second) < 2) or (second == "" and len(first) < 2)
    len1, len2 = len(first), len(second)
    dp = [[0] * (len2 + 1) for _ in range(len1 + 1)]
    for index in range(len2 + 1):
        dp[0][index] = index
    for index in range(len1 + 1):
        dp[index][0] = index

    for row in range(1, len1 + 1):
        for col in range(1, len2 + 1):
            left = dp[row][col - 1] + 1
            down = dp[row - 1][col] + 1
            left_down = dp[row - 1][col - 1]

            if first[row - 1] != second[col - 1]:
                left_down += 1

            dp[row][col] = min(left, min(down, left_down))

    return dp[-1][-1] == 0 or dp[-1][-1] == 1


if __name__ == '__main__':
    print(oneEditAway("pale", "ple"))
