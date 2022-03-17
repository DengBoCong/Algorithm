from typing import List
from collections import Counter


class MagicDictionary:

    def __init__(self):
        self.words = {}

    def buildDict(self, dictionary: List[str]) -> None:
        for word in dictionary:
            length = len(word)
            if length not in self.words:
                self.words[length] = []
            self.words[length].append(word)

    def search(self, searchWord: str) -> bool:
        length = len(searchWord)
        if length not in self.words:
            return False
        return any(sum(ch1 != ch2 for ch1, ch2 in zip(word, searchWord)) == 1
                   for word in self.words[length])


class MagicDictionary1:

    def __init__(self):
        self.counter = Counter()
        self.words = set()

    def buildDict(self, dictionary: List[str]) -> None:
        for word in dictionary:
            self.words.add(word)
            for i in range(len(word)):
                self.counter[word[:i] + "*" + word[i + 1:]] += 1

    def search(self, searchWord: str) -> bool:
        return any(self.counter[searchWord[:i] + "*" + searchWord[i + 1:]] > 1 or
                   self.counter[searchWord[:i] + "*" + searchWord[i + 1:]] == 1 and searchWord not in self.words
                   for i in range(len(searchWord)))
