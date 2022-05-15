from typing import List


def largestTriangleArea(points: List[List[int]]) -> float:
    length, res = len(points), 0.
    for i in range(length - 2):
        for j in range(i + 1, length - 1):
            for k in range(j + 1, length):
                res = max(res, abs(points[i][0]*points[j][1] + points[j][0]*points[k][1] + points[k][0]*points[i][1] - points[i][0]*points[k][1] - points[j][0]*points[i][1] - points[k][0]*points[j][1]) / 2.0)

    return res

if __name__ == '__main__':
    print(largestTriangleArea([[1,0],[0,0],[0,1]]))

