def reverseWords(s: str) -> str:
    s = s.strip().split()[::-1]
    return " ".join(s)

if __name__ == "__main__":
    print(reverseWords("the sky is blue"))