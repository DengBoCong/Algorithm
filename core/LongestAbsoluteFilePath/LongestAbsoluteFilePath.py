def lengthLongestPath(input: str) -> int:
    st = []
    ans, i, n = 0, 0, len(input)
    while i < n:
        depth = 1
        while i < n and input[i] == "\t":
            depth += 1
            i += 1

        length, is_file = 0, False
        while i < n and input[i] != "\n":
            if input[i] == ".":
                is_file = True
            length += 1
            i += 1
        i += 1

        while len(st) >= depth:
            st.pop()
        if st:
            length += st[-1] + 1
        if is_file:
            ans = max(ans, length)
        else:
            st.append(length)

    return ans
