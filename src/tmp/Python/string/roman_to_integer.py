def romanToInt(s: str) -> int:
    remain = {"M":1000, "CM":900, "D":500, "CD":400,"C":100, "XC":90, "L":50, "XL":40, "X":10, "IX":9, "V":5, "IV":4, "III":3, "II":2, "I":1}
    start, result = 0, 0
    for key, value in remain.items():
        length = len(key)
        end = start + length
        while s[start:end] == key:
            result += value
            start = end
            end = start + length
    
    return result

if __name__ == "__main__":
     print(romanToInt("MCMXCIV"))
