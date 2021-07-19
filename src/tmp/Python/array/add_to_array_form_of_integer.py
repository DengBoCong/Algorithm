def addToArrayForm_add(A: list, K: int) -> list:
    length = len(A)
    result = []
    for i in range(length - 1, -1, -1):
        sum = A[i] + K % 10
        K //= 10
        if (sum >= 10):
            K += 1
            sum -= 10
        result.append(sum)
    while K > 0:
        result.append(K % 10)
        K //= 10
    return result[::-1]


def addToArrayForm(A: list, K: int) -> list:
    length = len(A)
    result = []
    for i in range(length - 1, -1, -1):
        K = A[i] + K
        result.append(K % 10)
        K //= 10
    while K > 0:
        result.append(K % 10)
        K //= 10
    return result[::-1]


if __name__ == "__main__":
    print(addToArrayForm(A=[1, 2, 0, 0], K=34))
