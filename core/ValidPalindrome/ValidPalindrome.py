def isPalindrome(s: str) -> bool:
    left, right = 0, len(s) - 1
    s = s.lower()
    while left < right:
        while left < right and not s[left].isdigit() and not s[left].isalpha():
            left += 1
        while left < right and not s[right].isdigit() and not s[right].isalpha():
            right -= 1
        if left < right and s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True



