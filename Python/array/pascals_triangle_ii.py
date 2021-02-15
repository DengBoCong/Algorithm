from typing import List

def getRow(rowIndex: int) -> List[int]:
    result = [1]
    for i in range(rowIndex):
        for j in range(1, i + 1):
            
            if j == 1:
                temp = result[j]
                result[j] = result[j - 1] + result[j]
            else:
                remain = result[j]
                result[j] = result[j] + temp
                temp = remain
            
        result.append(1)
    
    return result

if __name__ == "__main__":
    print(getRow(1))

