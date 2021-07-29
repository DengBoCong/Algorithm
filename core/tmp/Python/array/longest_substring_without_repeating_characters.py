import collections


def lengthOfLongestSubstring(s: str) -> int:
    count = collections.Counter()
    left, result = 0, 0,
    for index, ch in enumerate(s):
        if count[ch] == 0:
            result = max(result, index - left + 1)
        count[ch] += 1

        while count[ch] > 1:
            count[s[left]] -= 1
            left += 1

    return result


if __name__ == "__main__":
    print(lengthOfLongestSubstring(""))
