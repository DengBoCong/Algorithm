def bulbSwitch(n: int) -> int:
    result = 0
    for i in range(1, n + 1):
        if i * i <= n:
            result += 1
        else:
            break
    return result

if __name__ == "__main__":
    print(bulbSwitch(100000000))
