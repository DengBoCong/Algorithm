from typing import List


def exist(board: List[List[str]], word: str) -> bool:
    m, n, length = len(board), len(board[0]), len(word)

    def dfs(row, col, point):
        if point == length - 1 and board[row][col] == word[point]:
            return True
        if board[row][col] != word[point]:
            return False
        board[row][col] = "_"
        for new_row, new_col in [[row, col + 1], [row, col - 1], [row + 1, col], [row - 1, col]]:
            if 0 <= new_row < m and 0 <= new_col < n and dfs(new_row, new_col, point + 1):
                return True
        board[row][col] = word[point]
        return False

    for i in range(m):
        for j in range(n):
            if board[i][j] == word[0] and dfs(i, j, 0):
                return True

    return False


if __name__ == '__main__':
    print(exist([["a"]], "a"))

