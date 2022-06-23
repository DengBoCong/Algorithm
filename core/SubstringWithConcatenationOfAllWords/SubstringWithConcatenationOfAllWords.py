from typing import List
from copy import deepcopy


def findSubstring(s: str, words: List[str]) -> List[int]:
    word_len, size, length = len(words[0]), len(words), len(s)
    index, word_map, res = 0, {}, []
    for word in words:
        word_map[word] = word_map.get(word, 0) + 1
    while index <= length - size * word_len:
        temp_map, flag = deepcopy(word_map), True
        for point in range(index, index + size * word_len, word_len):
            if s[point:point+word_len] not in temp_map or temp_map[s[point:point+word_len]] <= 0:
                flag = False
                break
            temp_map[s[point:point+word_len]] -= 1

        if flag:
            res.append(index)

        index += 1

    return res





