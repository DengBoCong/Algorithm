def canPlaceFlowers(flowerbed: list, n: int) -> bool:
    count, m, prev = 0, len(flowerbed), -1
    for i in range(m):
        if flowerbed[i] == 1:
            if prev < 0:
                count += i // 2
            else:
                count += (i - prev - 2) // 2
            if count >= n:
                return True
            prev = i
    if prev < 0:
        count += (m + 1) // 2
    else:
        count += (m - prev - 1) // 2

    return count >= n


if __name__ == "__main__":
    print(canPlaceFlowers(flowerbed=[1, 0, 0, 0, 1], n=2))
