def convert(s: str, numRows: int) -> str:
    res_matrix = [[] for _ in range(numRows)]
    cur_point, flag = 0, "down"
    for ch in s:
        res_matrix[cur_point].append(ch)
        if flag == "down" and cur_point + 1 < numRows:
            cur_point += 1
        elif flag == "down":
            cur_point -= 1
            flag = "up"
        elif flag == "up" and cur_point - 1 >= 0:
            cur_point -= 1
        else:
            cur_point += 1
            flag = "down"

    return "".join(["".join(item) for item in res_matrix])


if __name__ == '__main__':
    print(convert(s="AB", numRows=1))
