def isPalindrome(x: int) -> bool:
    if x < 0:
        return False
    
    remain = str(x)
    left, right = 0, len(remain) - 1
    while left < right:
        if remain[left] != remain[right]:
            return False
        left += 1
        right -= 1
    
    return True

if __name__ == "__main__":
    print(isPalindrome(x = 121))