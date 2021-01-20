def prefixesDivBy5(A: list) -> list:
    M = 0
    result = []
    for num in A:
        M = M * 2 + num
        if M % 5 == 0:
            result.append(True)
        else:
            result.append(False)
    return result


if __name__ == "__main__":
    print(prefixesDivBy5([1, 1, 1, 0, 1]))
