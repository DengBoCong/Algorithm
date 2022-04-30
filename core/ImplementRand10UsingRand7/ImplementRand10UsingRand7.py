def rand7():
    pass


def rand10():
    while True:
        row, col = rand7(), rand7()
        idx = (row - 1) * 7 + col
        if idx <= 40:
            return 1 + (idx - 1) % 10
