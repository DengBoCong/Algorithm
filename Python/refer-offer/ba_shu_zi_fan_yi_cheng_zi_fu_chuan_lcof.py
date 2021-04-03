def translateNum(num: int) -> int:
    res = [0]
    strNum = str(num)
    length = len(strNum)
    def dfs(point: int):
        if point == length:
            res[0] += 1
            return
        if  point < length - 1 and strNum[point] != '0' and int(strNum[point:point + 2]) <= 25:
            dfs(point + 2)
        dfs(point + 1)
        
    dfs(0)
    return res[0]

if __name__ == "__main__":
    print(translateNum(506))
