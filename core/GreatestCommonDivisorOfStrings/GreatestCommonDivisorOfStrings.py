def gcdOfStrings(str1: str, str2: str) -> str:
    length1, length2 = len(str1), len(str2)

    def is_div_str(cur_str, length):
        temp_str = cur_str[:length]
        temp_length = length
        while temp_length <= len(cur_str):
            if temp_str != cur_str[temp_length - length:temp_length]:
                return False
            temp_length += length

        return True

    point = min(length1, length2)
    while point > 0:
        if length1 % point == 0 and length2 % point == 0 and\
                str1[:point] == str2[:point] and is_div_str(str1, point) and is_div_str(str2, point):
            return str1[:point]
        point -= 1

    return ""


if __name__ == '__main__':
    print(gcdOfStrings(str1="ABCABC", str2="ABC"))
