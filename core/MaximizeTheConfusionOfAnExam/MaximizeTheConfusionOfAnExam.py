def maxConsecutiveAnswers(answerKey: str, k: int) -> int:
    length = len(answerKey)
    left, right = 0, 0
    res, t_count, f_count = 0, 0, 0
    while right < length:
        while right < length and (t_count <= k or f_count <= k):
            if answerKey[right] == "T":
                t_count += 1
            else:
                f_count += 1
            right += 1

        res = max(res, right - left if t_count <= k or f_count <= k else right - left - 1)

        while right < length and left < right and (t_count > k and f_count > k):
            if answerKey[left] == "T":
                t_count -= 1
            else:
                f_count -= 1
            left += 1

    res = max(res, right - left if t_count <= k or f_count <= k else right - left - 1)

    return res

if __name__ == '__main__':
    print(maxConsecutiveAnswers(answerKey = "FFFTTFTTFT", k = 3))

