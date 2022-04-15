from typing import List

def restoreIpAddresses(s: str) -> List[str]:
    res, remain = [], {}
    def dfs(sub_str, num, sub_res):
        if num == 4 and 0 < len(sub_str) <= 3 and 0 <= int(sub_str) <= 255:
            if len(sub_str) > 1 and sub_str.startswith("0"):
                return
            sub_res.append(sub_str)
            temp = ".".join(sub_res)
            if temp not in remain:
                res.append(temp)
                remain[temp] = True
            sub_res.pop()
        if num < 4:
            for i in range(1, 4):
                if (sub_str.startswith("0") and i != 1) or sub_str[:i] == "" or not (0 <= int(sub_str[:i]) <= 255):
                    continue
                sub_res.append(sub_str[:i])
                dfs(sub_str[i:], num + 1, sub_res)
                sub_res.pop()

    dfs(s, 1, [])
    return res

if __name__ == '__main__':
    print(restoreIpAddresses("0000"))



