from typing import List

def transpose(matrix: List[List[int]]) -> List[List[int]]:
    row = len(matrix)
    col = len(matrix[0])

    result = list()
    for i in range(col):
        temp = list()
        for j in range(row):
            temp.append(matrix[j][i])
        result.append(temp)
    return result

if __name__ == "__main__":
    print(transpose([[1,2,3],[4,5,6],[7,8,9]]))
