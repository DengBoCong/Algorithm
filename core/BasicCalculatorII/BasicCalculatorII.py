def calculate(s: str) -> int:
    stack, num, length, pre_op = [], 0, len(s), "+"
    for i in range(length):
        if s[i].isdigit():
            num = num * 10 + int(s[i])
        if i == length - 1 or s[i] in "+-*/":
            if pre_op == "+":
                stack.append(num)
            elif pre_op == "-":
                stack.append(-num)
            elif pre_op == "*":
                stack.append(stack.pop() * num)
            else:
                stack.append(int(stack.pop() / num))
            pre_op = s[i]
            num = 0

    return sum(stack)




if __name__ == '__main__':
    print(calculate("0-2147483647"))

