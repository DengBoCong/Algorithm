def decodeString(s: str) -> str:
    stack = []
    for ch in s:
        if ch == "]":
            sub_str = ""
            while stack and stack[-1] != "[":
                sub_str = stack.pop() + sub_str
            if stack:
                stack.pop()
                num = ""
                while stack and stack[-1].isdigit():
                    num = stack.pop() + num
                num = int(num)
                temp = ""
                for _ in range(num):
                    temp += sub_str
                stack.append(temp)
        else:
            stack.append(ch)

    return "".join(stack)

if __name__ == '__main__':
    print(decodeString("100[leetcode]"))


