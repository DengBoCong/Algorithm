def validIPAddress(queryIP: str) -> str:
    if queryIP.find(".") != -1:
        # IPv4
        last = -1
        for i in range(4):
            cur = (len(queryIP) if i == 3 else queryIP.find(".", last + 1))
            if cur == -1:
                return "Neither"
            if not 1 <= cur - last - 1 <= 3:
                return "Neither"

            addr = 0
            for j in range(last + 1, cur):
                if not queryIP[j].isdigit():
                    return "Neither"
                addr = addr * 10 + int(queryIP[j])

            if addr > 255:
                return "Neither"
            if addr > 0 and queryIP[last + 1] == "0":
                return "Neither"
            if addr == 0 and cur - last - 1 > 1:
                return "Neither"

            last = cur

        return "IPv4"
    else:
        # IPv6
        last = -1
        for i in range(8):
            cur = (len(queryIP) if i == 7 else queryIP.find(":", last + 1))
            if cur == -1:
                return "Neither"
            if not 1 <= cur - last - 1 <= 4:
                return "Neither"

            for j in range(last + 1, cur):
                if not queryIP[j].isdigit() and not ("a" <= queryIP[j].lower() <= "f"):
                    return "Neither"

            last = cur

        return "IPv6"
