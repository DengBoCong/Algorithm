def numEquivDominoPairs(dominoes: list) -> int:
    remain = [0] * 100
    ret = 0
    for x, y in dominoes:
        val = (x * 10 + y if x <= y else y * 10 + x)
        ret += remain[val]
        remain[val] += 1
        
    return ret


if __name__ == "__main__":
    print(numEquivDominoPairs(dominoes=[[1,2],[1,2],[1,2],[1,1],[1,2],[2,2]]))
