def replaceSpace(s: str) -> str:
    result = ""
    length = len(s)
    for i in range(length):
        if s[i] != ' ':
            result += s[i]
        else:
            result += "%20"
    
    return result