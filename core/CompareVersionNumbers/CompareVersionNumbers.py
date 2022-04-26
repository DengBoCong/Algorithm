def compareVersion(version1: str, version2: str) -> int:
    v1 = [int(item) for item in version1.split(".")]
    v2 = [int(item) for item in version2.split(".")]
    len1, len2 = len(v1), len(v2)
    for index in range(max(len1, len2)):
        val1 = v1[index] if index < len1 else 0
        val2 = v2[index] if index < len2 else 0
        if val1 != val2:
            return 1 if val1 > val2 else -1

    return 0




