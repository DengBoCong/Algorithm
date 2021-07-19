def checkStraightLine(coordinates: list) -> bool:
    length = len(coordinates)
    if length <= 2:
        return True

    deltaX, deltaY = coordinates[0][0], coordinates[0][1]
    for i in range(length):
        coordinates[i][0] -= deltaX
        coordinates[i][1] -= deltaY

    A, B = -coordinates[1][1], coordinates[1][0]
    for i in range(2, length):
        if A * coordinates[i][0] + B * coordinates[i][1] != 0:
            return False

    return True


if __name__ == "__main__":
    print(checkStraightLine([[1, 1], [2, 2], [3, 4], [4, 5], [5, 6], [7, 7]]))
