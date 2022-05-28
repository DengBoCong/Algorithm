def removeOuterParentheses(s: str) -> str:
    res, stack, length = "", [], len(s)
    for index, ch in enumerate(s):
        if ch == "(":
            stack.append(index)
        else:
            pre_index = stack.pop()
            if not stack:
                res += s[pre_index + 1:index]
    return res





