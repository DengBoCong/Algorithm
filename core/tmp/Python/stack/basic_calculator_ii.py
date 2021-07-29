def calculate(s: str) -> int:
    n = len(s)
    stack = []
    pre_sign = '+'
    num = 0
    for i in range(n):
        if s[i] != ' ' and s[i].isdigit():
            num = num * 10 + ord(s[i]) - ord('0')
        if i == n - 1 or s[i] in '+-*/':
            if pre_sign == '+':
                stack.append(num)
            elif pre_sign == '-':
                stack.append(-num)
            elif pre_sign == '*':
                stack.append(stack.pop() * num)
            else:
                stack.append(int(stack.pop() / num))
            pre_sign = s[i]
            num = 0
    return sum(stack)

if __name__ == "__main__":
    print(calculate(" 3+5 / 2 "))