from typing import List
from collections import Counter

def mostCommonWord(paragraph: str, banned: List[str]) -> str:
    p_char = ["!", "?", "'", ",", ";", "."]
    left, right, length = 0, 0, len(paragraph)
    res, counter = "", Counter()

    while right < length:
        while right < length and paragraph[right].isalpha():
            right += 1
        ch = paragraph[left:right].lower()
        counter[ch] += 1
        if counter[ch] > counter[res] and ch not in banned:
            res = ch

        while right < length and not paragraph[right].isalpha():
            right += 1
        left = right

    return res


if __name__ == '__main__':
    print(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"]))







