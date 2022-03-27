def isValid(s: str) -> bool:
    stack = []
    for ch in s:
        if stack and ((ch == ")" and stack[-1] == "(") or (ch == "}" and stack[-1] == "{") or (ch == "]" and stack[-1] == "[")):
            stack.pop()
        else:
            stack.append(ch)

    return len(stack) == 0


if __name__ == '__main__':
    print(isValid("]"))
