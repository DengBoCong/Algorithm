MOUSE_TURN = 0
CAT_TURN = 1
UNKNOWN = 0
MOUSE_WIN = 1
CAT_WIN = 2
MAX_MOVES = 1000
DIRS = ((-1, 0), (1, 0), (0, -1), (0, 1))

class Solution:
    def canMouseWin(self, grid: List[str], catJump: int, mouseJump: int) -> bool:
        rows, cols = len(grid), len(grid[0])

        def getPos(row: int, col: int) -> int:
            return row * cols + col

        startMouse = startCat = food = 0
        for i, row in enumerate(grid):
            for j, ch in enumerate(row):
                if ch == 'M':
                    startMouse = getPos(i, j)
                elif ch == 'C':
                    startCat = getPos(i, j)
                elif ch == 'F':
                    food = getPos(i, j)

        # 计算每个状态的度
        total = rows * cols
        degrees = [[[0, 0] for _ in range(total)] for _ in range(total)]
        for mouse in range(total):
            mouseRow, mouseCol = divmod(mouse, cols)
            if grid[mouseRow][mouseCol] == '#':
                continue
            for cat in range(total):
                catRow, catCol = divmod(cat, cols)
                if grid[catRow][catCol] == '#':
                    continue
                degrees[mouse][cat][MOUSE_TURN] += 1
                degrees[mouse][cat][CAT_TURN] += 1
                for dx, dy in DIRS:
                    row, col, jump = mouseRow + dx, mouseCol + dy, 1
                    while 0 <= row < rows and 0 <= col < cols and grid[row][col] != '#' and jump <= mouseJump:
                        nextMouse = getPos(row, col)
                        nextCat = getPos(catRow, catCol)
                        degrees[nextMouse][nextCat][MOUSE_TURN] += 1
                        row += dx
                        col += dy
                        jump += 1
                    row, col, jump = catRow + dx, catCol + dy, 1
                    while 0 <= row < rows and 0 <= col < cols and grid[row][col] != '#' and jump <= catJump:
                        nextMouse = getPos(mouseRow, mouseCol)
                        nextCat = getPos(row, col)
                        degrees[nextMouse][nextCat][CAT_TURN] += 1
                        row += dx
                        col += dy
                        jump += 1

        results = [[[[0, 0], [0, 0]] for _ in range(total)] for _ in range(total)]
        q = deque()

        # 猫和老鼠在同一个单元格，猫获胜
        for pos in range(total):
            row, col = divmod(pos, cols)
            if grid[row][col] == '#':
                continue
            results[pos][pos][MOUSE_TURN][0] = CAT_WIN
            results[pos][pos][MOUSE_TURN][1] = 0
            results[pos][pos][CAT_TURN][0] = CAT_WIN
            results[pos][pos][CAT_TURN][1] = 0
            q.append((pos, pos, MOUSE_TURN))
            q.append((pos, pos, CAT_TURN))

        # 猫和食物在同一个单元格，猫获胜
        for mouse in range(total):
            mouseRow, mouseCol = divmod(mouse, cols)
            if grid[mouseRow][mouseCol] == '#' or mouse == food:
                continue
            results[mouse][food][MOUSE_TURN][0] = CAT_WIN
            results[mouse][food][MOUSE_TURN][1] = 0
            results[mouse][food][CAT_TURN][0] = CAT_WIN
            results[mouse][food][CAT_TURN][1] = 0
            q.append((mouse, food, MOUSE_TURN))
            q.append((mouse, food, CAT_TURN))

        # 老鼠和食物在同一个单元格且猫和食物不在同一个单元格，老鼠获胜
        for cat in range(total):
            catRow, catCol = divmod(cat, cols)
            if grid[catRow][catCol] == '#' or cat == food:
                continue
            results[food][cat][MOUSE_TURN][0] = MOUSE_WIN
            results[food][cat][MOUSE_TURN][1] = 0
            results[food][cat][CAT_TURN][0] = MOUSE_WIN
            results[food][cat][CAT_TURN][1] = 0
            q.append((food, cat, MOUSE_TURN))
            q.append((food, cat, CAT_TURN))

        def getPrevStates(mouse: int, cat: int, turn: int) -> List[Tuple[int, int, int]]:
            mouseRow, mouseCol = divmod(mouse, cols)
            catRow, catCol = divmod(cat, cols)
            prevTurn = CAT_TURN if turn == MOUSE_TURN else MOUSE_TURN
            maxJump = mouseJump if prevTurn == MOUSE_TURN else catJump
            startRow = mouseRow if prevTurn == MOUSE_TURN else catRow
            startCol = mouseCol if prevTurn == MOUSE_TURN else catCol
            prevStates = [(mouse, cat, prevTurn)]
            for dx, dy in DIRS:
                i, j, jump = startRow + dx, startCol + dy, 1
                while 0 <= i < rows and 0 <= j < cols and grid[i][j] != '#' and jump <= maxJump:
                    prevMouseRow = i if prevTurn == MOUSE_TURN else mouseRow
                    prevMouseCol = j if prevTurn == MOUSE_TURN else mouseCol
                    prevCatRow = catRow if prevTurn == MOUSE_TURN else i
                    prevCatCol = catCol if prevTurn == MOUSE_TURN else j
                    prevMouse = getPos(prevMouseRow, prevMouseCol)
                    prevCat = getPos(prevCatRow, prevCatCol)
                    prevStates.append((prevMouse, prevCat, prevTurn))
                    i += dx
                    j += dy
                    jump += 1
            return prevStates

        # 拓扑排序
        while q:
            mouse, cat, turn = q.popleft()
            result = results[mouse][cat][turn][0]
            moves = results[mouse][cat][turn][1]
            for prevMouse, prevCat, prevTurn in getPrevStates(mouse, cat, turn):
                if results[prevMouse][prevCat][prevTurn][0] == UNKNOWN:
                    if result == MOUSE_WIN and prevTurn == MOUSE_TURN or result == CAT_WIN and prevTurn == CAT_TURN:
                        results[prevMouse][prevCat][prevTurn][0] = result
                        results[prevMouse][prevCat][prevTurn][1] = moves + 1
                        q.append((prevMouse, prevCat, prevTurn))
                    else:
                        degrees[prevMouse][prevCat][prevTurn] -= 1
                        if degrees[prevMouse][prevCat][prevTurn] == 0:
                            loseResult = CAT_WIN if prevTurn == MOUSE_TURN else MOUSE_WIN
                            results[prevMouse][prevCat][prevTurn][0] = loseResult
                            results[prevMouse][prevCat][prevTurn][1] = moves + 1
                            q.append((prevMouse, prevCat, prevTurn))
        return results[startMouse][startCat][MOUSE_TURN][0] == MOUSE_WIN and results[startMouse][startCat][MOUSE_TURN][1] <= MAX_MOVES
