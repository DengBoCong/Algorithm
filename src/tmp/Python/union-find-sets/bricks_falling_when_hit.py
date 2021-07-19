def hitBricks(grid: list, hits: list) -> list:
    def get_size_of_set(x):
        return size_of_set[find(x)]

    def find(x):
        root = x
        while father[root] != None:
            root = father[root]

        while x != root:
            original_father = father[x]
            father[x] = root
            x = original_father

        return root

    def is_connected(x, y):
        return find(x) == find(y)

    def merge(x, y):
        root_x, root_y = find(x), find(y)

        if root_x != root_y:
            father[root_x] = root_y
            size_of_set[root_y] += size_of_set[root_x]
            del size_of_set[root_x]

    def add(x):
        if x not in father:
            father[x] = None
            size_of_set[x] = 1

    def initialize(m, n, grid, hits):
        add(CEIL)
        for x, y in hits:
            grid[x][y] -= 1

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    add((i, j))

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    merge_neighbors(m, n, grid, i, j)

        for j in range(n):
            if grid[0][j] == 1:
                merge((0, j), CEIL)

    def is_valid(x, y, grid, m, n):
        return 0 <= x < m and 0 <= y < n and grid[x][y] == 1

    def merge_neighbors(m, n, grid, x, y):
        for dx, dy in DIRECTION:
            nx, ny = x + dx, y + dy
            if not is_valid(nx, ny, grid, m, n):
                continue
            merge((x, y), (nx, ny))

    father = {}
    size_of_set = {}
    CEIL = (-1, -1)
    DIRECTION = ((1, 0), (-1, 0), (0, 1), (0, -1))

    m, n = len(grid), len(grid[0])
    res = [0] * len(hits)

    initialize(m, n, grid, hits)
    for i in range(len(hits) - 1, -1, -1):
        x, y = hits[i][0], hits[i][1]

        grid[x][y] += 1
        if grid[x][y] != 1:
            continue

        after_hit = get_size_of_set(CEIL)
        add((x, y))
        merge_neighbors(m, n, grid, x, y)
        if x == 0:
            merge((x, y), CEIL)

        if is_connected((x, y), CEIL):
            before_hit = get_size_of_set(CEIL)
            res[i] = before_hit - after_hit - 1

    return res


if __name__ == "__main__":
    print(hitBricks(grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]))