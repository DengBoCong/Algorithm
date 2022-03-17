from typing import List


def findLongestWord(s: str, dictionary: List[str]) -> str:
    res = ""
    for word in dictionary:
        left, right = 0, 0
        while left < len(s) and right < len(word):
            while left < len(s) and s[left] != word[right]:
                left += 1

            if left < len(s) and s[left] == word[right]:
                left += 1
                right += 1

        if right == len(word) and right >= len(res):
            res = word if right > len(res) or res > word else res

    return res


if __name__ == '__main__':
    # print(findLongestWord(s="abpcplea", dictionary=["ale", "apple", "monkey", "plea"]))
    print(len("ettphsiunoglotjlccurlre"), len("ntgcykxhdfescxxypyew"))
