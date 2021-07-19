from typing import *

def permutation(s: str) -> List[str]:
    ans, res = list(s), list()
    
    def dfs(x):
        if x == len(ans) - 1:
            res.append(''.join(ans))
            return
        
        dic = set()
        for i in range(x, len(ans)):
            if ans[i] in dic: continue
            dic.add(ans[i])
            ans[i], ans[x] = ans[x], ans[i]
            dfs(x + 1)
            ans[i], ans[x] = ans[x], ans[i]
    
    dfs(0)
    return res

if __name__ == "__main__":
    print(permutation("acb"))