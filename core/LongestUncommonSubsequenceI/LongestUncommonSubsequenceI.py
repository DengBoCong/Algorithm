def findLUSlength(a: str, b: str) -> int:
    if a == b:
        return -1

    return len(a) if len(a) > len(b) else len(b)
