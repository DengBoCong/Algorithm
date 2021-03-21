def intToRoman(num: int) -> str:
    remain = {1000:"M", 900:"CM",500:"D",400:"CD",100:"C",90:"XC",50:"L",40:"XL",10:"X",9:"IX",5:"V",4:"IV",3:"III",2:"II",1:"I"}
    result = ""
    for key, value in remain.items():
        temp = num // key
        for _ in range(temp):
            result += value
        num %= key
        if num == 0:
            break
    
    return result
if __name__ == "__main__":
     print(intToRoman(3999))