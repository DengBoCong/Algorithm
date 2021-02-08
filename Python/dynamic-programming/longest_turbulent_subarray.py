from typing import List


def maxTurbulenceSize(arr: List[int]) -> int:
    n = len(arr)
    op, ne, result = 1, 1, 1
    for i in range(1, n):
        if arr[i] > arr[i - 1]:
            ne = op + 1
            op = 1
        elif arr[i] < arr[i - 1]:
            op = ne + 1
            ne = 1
        elif arr[i] == arr[i - 1]:
            op = 1
            ne = 1
        
        result = max(result, ne, op)

    return result


if __name__ == "__main__":
    print(maxTurbulenceSize([100]))
