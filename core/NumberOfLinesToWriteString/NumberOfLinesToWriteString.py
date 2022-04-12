from typing import List

def numberOfLines(widths: List[int], s: str) -> List[int]:
    row, remain, line = 0, 0, 0
    for ch in s:
        if widths[ord(ch) - 97] + line > 100:
            line = widths[ord(ch) - 97]
            row += 1
        else:
            line += widths[ord(ch) - 97]

    if line > 0:
        row += 1

    return [row, line]





