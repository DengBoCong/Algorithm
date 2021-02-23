import sys

def reverse(x: int) -> int:
    INTMAX10 = 214748364
    INTMIN10 = -214748364
    ans = 0
    while x:
        pop = x % 10 if x > 0 else x % -10
        x = x // 10 if x > 0 else int(x / 10)
        if ans > INTMAX10 or (ans == INTMAX10 and pop > 7):
            return 0
        if ans < INTMIN10 or (ans == INTMIN10 and pop < -8):
            return 0
        ans = ans * 10 + pop
    return ans

if __name__ == "__main__":
    print(reverse(-123))