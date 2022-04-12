from typing import List

def generateParenthesis(n: int) -> List[str]:
    res = ["()"]
    if n == 1:
        return res

    for _ in range(1, n):
        remain, temp_res = {}, []
        for item in res:
            length = len(item)
            for i in range(length + 1):
                com_str = item[0:i] + "()" + item[i:length + 1]
                if remain.get(com_str, True):
                    temp_res.append(com_str)
                    remain[com_str] = False
        res = temp_res

    return res


