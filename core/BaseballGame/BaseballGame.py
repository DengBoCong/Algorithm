from typing import List

def calPoints(ops: List[str]) -> int:
    scores = [0] * len(ops)
    res, cur, length = int(ops[0]), 1, len(ops)
    scores[0] = res
    for i in range(1, length):
        if ops[i] == "+":
            scores[cur] = scores[cur - 1] + scores[cur - 2]
        elif ops[i] == "D":
            scores[cur] = scores[cur - 1] * 2
        elif ops[i] == "C":
            cur -= 1
            res -= scores[cur]
            continue
        else:
            scores[cur] = int(ops[i])

        res += scores[cur]
        cur += 1

    return res


if __name__ == '__main__':
    print(calPoints(["5","-2","4","C","D","9","+","+"]))
