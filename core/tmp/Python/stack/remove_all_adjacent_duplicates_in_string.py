def removeDuplicates(S: str) -> str:
    stack = list()
    for s in S:
        if stack and stack[-1] == s:
            stack.pop()
        else:
            stack.append(s)
    return "".join(stack)
