from collections import Counter

def minWindow(s: str, t: str) -> str:
    t_counter, t_total = Counter(t), len(t)
    s_counter, s_total, s_length = Counter(), 0, len(s)
    left, right, res = 0, 0, ""
    while left <= right and right < s_length:
        while right < s_length and s_total < t_total:
            if s_counter[s[right]] < t_counter[s[right]]:
                s_total += 1
            if t_counter[s[right]] > 0:
                s_counter[s[right]] += 1
            right += 1

        while left < right and s_total == t_total and (
                s_counter[s[left]] == 0 or s_counter[s[left]] > t_counter[s[left]]):
            if s_counter[s[left]] > t_counter[s[left]]:
                s_counter[s[left]] -= 1
            left += 1

        if s_total == t_total and (res == "" or len(res) > right - left):
            res = s[left:right]

        s_counter[s[left]] -= 1
        left += 1
        s_total -= 1

    return res

if __name__ == '__main__':
    print(minWindow(s = "ADOBECODEBANC", t = "ABC"))







