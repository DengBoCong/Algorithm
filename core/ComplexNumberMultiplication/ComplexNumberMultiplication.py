def complexNumberMultiply(num1: str, num2: str) -> str:
    def extract_num(num):
        if num[-1] != "i":
            return int(num), 0
        start, b_str = 0, ""
        for i in range(len(num) - 2, -1, -1):
            start = i
            b_str = num[i] + b_str
            if num[i] in ["+", "-"]:
                while num[start] in ["+", "-"]:
                    start -= 1
                return 0 if start == -1 else int(num[:start + 1]), int(b_str)

    num1_a, num1_b = extract_num(num1)
    num2_a, num2_b = extract_num(num2)
    res1 = num1_a * num2_a + num1_b * num2_b * -1
    res2 = num1_a * num2_b + num2_a * num1_b

    return str(res1) + "+" + str(res2) + "i"


if __name__ == '__main__':
    print(complexNumberMultiply(num1="1+1i", num2="1-1i"))
