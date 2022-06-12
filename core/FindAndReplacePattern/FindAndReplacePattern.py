from typing import List


def findAndReplacePattern(words: List[str], pattern: str) -> List[str]:
    res = []

    for word in words:
        if len(word) != len(pattern):
            continue
        mapping1, mapping2, flag = {}, {}, True
        for ch1, ch2 in zip(word, pattern):
            if ch1 not in mapping1 and ch2 not in mapping2:
                mapping1[ch1] = ch2
                mapping2[ch2] = ch1
            if mapping1.get(ch1, "") != ch2 or mapping2.get(ch2, "") != ch1:
                flag = False
                break

        if flag:
            res.append(word)

    return res





