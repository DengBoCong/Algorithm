def middle_search(s: str, left: int, right: int):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return left + 1, right - 1


def longestPalindrome(s: str) -> str:
    start, end = 0, 0
    for i in range(len(s)):
        left1, right1 = middle_search(s, i, i)
        left2, right2 = middle_search(s, i, i + 1)
        if right1 - left1 > end - start:
            start, end = left1, right1
        if right2 - left2 > end - start:
            start, end = left2, right2

    return s[start: end + 1]

def expand(s, left, right):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    
    return (right - left - 2) // 2

def longestPalindromeManacher(s: str) -> str:
    start, end = 0, -1
    s = '#' + '#'.join(list(s)) + '#'
    arm_len = []
    right = -1
    j = -1
    for i in range(len(s)):
        if right >= i:
            i_sym = 2 * j - i
            min_arm_len = min(arm_len[i_sym], right - i)
            cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len)
        else:
            cur_arm_len = expand(s, i, i)
        arm_len.append(cur_arm_len)
        if i + cur_arm_len > right:
            j = i
            right = i + cur_arm_len
        if 2 * cur_arm_len + 1 > end - start:
            start = i - cur_arm_len
            end = i + cur_arm_len
    print(arm_len)
    return s[start + 1: end + 1:2]

if __name__ == "__main__":
    print(longestPalindromeManacher("babad"))
