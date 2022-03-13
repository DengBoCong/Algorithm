from typing import List


def validUtf8(data: List[int]) -> bool:
    cur_point, count = 0, 0
    for item in data:
        uni = ("0" * 8 + bin(item).replace("0b", ""))[-8:]
        print(uni, count)
        if count != 0 and not uni.startswith("10"):
            return False
        if count != 0 and uni.startswith("10"):
            count -= 1
        elif count == 0 and uni.startswith("10"):
            return False
        elif count == 0 and uni.startswith("11"):
            count = 1
            for i in range(2, 8):
                if uni[i] == "0":
                    break
                count += 1
            if count > 4:
                return False

    return count == 0


if __name__ == '__main__':
    print(validUtf8([250,145,145,145,145]))
