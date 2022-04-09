def reachingPoints(sx: int, sy: int, tx: int, ty: int) -> bool:
    while tx > sx and ty > sy and tx != ty:
        if tx > ty:
            tx %= ty
        else:
            ty %= tx

    if tx == sx and ty == sy:
        return True
    elif tx > sx and ty == sy:
        return (tx - sx) % ty == 0
    elif ty > sy and tx == sx:
        return (ty - sy) % tx == 0
    else:
        return False



