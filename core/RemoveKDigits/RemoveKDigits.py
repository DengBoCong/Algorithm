def removeKdigits(num: str, k: int) -> str:
    num_stack = []
    for digit in num:
        while k and num_stack and num_stack[-1] > digit:
            num_stack.pop()
            k -= 1

        num_stack.append(digit)

    final = num_stack[:-k] if k else num_stack
    return "".join(final).lstrip("0") or "0"








