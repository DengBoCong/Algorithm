from typing import List


def longestWord(words: List[str]) -> str:
    set_words = {""}
    words.sort(key=lambda x: (-len(x), x), reverse=True)
    res = ""
    for word in words:
        if word[:-1] in set_words:
            res = word
            set_words.add(word)

    return res


if __name__ == '__main__':
    print(longestWord(words=["a", "banana", "app", "appl", "ap", "apply", "apple"]))
