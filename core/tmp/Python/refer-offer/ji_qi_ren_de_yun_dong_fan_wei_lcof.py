def movingCount(m: int, n: int, k: int) -> int:
    def cal(first, second):
        total = 0
        while first != 0:
            total += first % 10
            first //= 10
        while second != 0:
            total += second % 10
            second //= 10
        
        return total

    result = list()
    def dfs(row, col):
        if not 0 <= row < m or not 0 <= col < n or cal(row, col) > k:
            return
        
        if row * n + col in result:
            return

        result.append(row * n + col)
        dfs(row - 1, col)
        dfs(row + 1, col)
        dfs(row, col + 1)
        dfs(row, col - 1)
    
    dfs(0, 0)
    return len(result)

if __name__ == "__main__":
    print(movingCount(m = 2, n = 2, k = 10))
