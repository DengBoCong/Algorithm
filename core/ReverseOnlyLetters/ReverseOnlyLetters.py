def reverseOnlyLetters(s: str) -> str:
    left, right = 0, len(s) - 1
    res = list(s)
    while left < right:
        while left < right and not res[left].isalpha():
            left += 1
        while left < right and not res[right].isalpha():
            right -= 1
        temp = res[left]
        res[left] = res[right]
        res[right] = temp

        left += 1
        right -= 1

    return "".join(res)


if __name__ == '__main__':
    print(reverseOnlyLetters("a-bC-dEf-ghIj"))
