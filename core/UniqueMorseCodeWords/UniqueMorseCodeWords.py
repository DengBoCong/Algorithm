from typing import List


def uniqueMorseRepresentations(words: List[str]) -> int:
    morse = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
             ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]
    word_to_morse_map = {chr(index + 97): item for index, item in enumerate(morse)}
    res = {}
    for word in words:
        word_morse = ""
        for ch in word:
            word_morse += word_to_morse_map[ch]
        res[word_morse] = res.get(word_morse, 0) + 1

    return len(res)


if __name__ == '__main__':
    print(uniqueMorseRepresentations(["gin", "zen", "gig", "msg"]))
