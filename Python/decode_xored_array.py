def decode(encoded: list, first: int) -> list:
    decode_array = [first]
    for i in range(1, len(encoded) + 1):
        temp = decode_array[i - 1] ^ encoded[i - 1]
        decode_array.append(temp)

    return decode_array


if __name__ == "__main__":
    print(decode(encoded = [6,2,7,3], first = 4))
