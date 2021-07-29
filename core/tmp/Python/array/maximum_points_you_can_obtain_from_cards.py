from typing import List

def maxScore(cardPoints: List[int], k: int) -> int:
    length = len(cardPoints)
    if length == k:
        return sum(cardPoints)

    front, back = [cardPoints[0]], [cardPoints[-1]]
    for i in range(1, length):
        front.append(front[i - 1] + cardPoints[i])
        back.append(back[i - 1] + cardPoints[length - 1 - i])
    
    result = max(front[k - 1], back[k - 1])
    flag = k - 2
    while flag >= 0:
        result = max(result, front[flag] + back[k - 2 - flag])
        flag -= 1
    
    return result

def maxScore_slid(cardPoints: List[int], k: int) -> int:
    length = len(cardPoints)
    s = sum(cardPoints[:length - k])
    min_sum = s
    for i in range(length - k, length):
        s += cardPoints[i] - cardPoints[i - length + k]
        min_sum = min(min_sum, s)
    return sum(cardPoints) - min_sum

if __name__ == "__main__":
    print(maxScore_slid(cardPoints = [1,79,80,1,1,1,200,1], k = 3))
