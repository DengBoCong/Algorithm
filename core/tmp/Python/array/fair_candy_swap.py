def fairCandySwap(A: list, B: list) -> list:
    sum_a = sum(A)
    sum_b = sum(B)
    search = set(B)

    result = []
    total = (sum_a + sum_b) // 2
    for a in A:
        if total - sum_a + a in search:
            result = [a, total - sum_a + a]
            break

    return result


if __name__ == "__main__":
    print(fairCandySwap(A = [1,2,5], B = [2,4]))
