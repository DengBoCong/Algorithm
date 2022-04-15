def reverseWords(s: str) -> str:
    res, length = [], len(s)
    cur = length - 1
    while cur >= 0:
        while cur >= 0 and s[cur] == " ":
            cur -= 1

        if cur == -1:
            break
        point = cur
        while point >= 0 and s[point] != " ":
            point -= 1

        res.append(s[point + 1:cur + 1])
        cur = point

    return " ".join(res)


if __name__ == '__main__':
    print(f'[{reverseWords("  hello world  ")}]')
