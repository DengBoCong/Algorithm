from typing import List


def reorderLogFiles(logs: List[str]) -> List[str]:
    def trans(log):
        a, b = log.split(" ", 1)
        return (0, b, a) if b[0].isalpha() else (1,)

    logs.sort(key=trans)
    return logs
