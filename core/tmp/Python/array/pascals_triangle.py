from typing import List

def generate(numRows: int) -> List[List[int]]:
    if numRows == 0:
        return []
    result = [[1]]
    for i in range(numRows - 1):
        row = result[i].copy()
        for j in range(1, i + 1):
            if j == 1:
                temp = row[j]
                row[j] = row[j] + row[j - 1]
            else:
                remain = row[j]
                row[j] = row[j] + temp
                temp = remain
        
        row.append(1)
        result.append(row)
    
    return result

if __name__ == "__main__":
    print(generate(5))