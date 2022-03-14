from typing import List


def findRestaurant(list1: List[str], list2: List[str]) -> List[str]:
    remain = {}
    for index, item in enumerate(list1):
        if item in remain:
            continue
        remain[item] = index

    res, min_sum = [], len(list1) + len(list2)
    for index, item in enumerate(list2):
        if item in remain:
            if index + remain[item] < min_sum:
                min_sum = index + remain[item]
                res = [item]
            elif index + remain[item] == min_sum:
                res.append(item)

    return res


if __name__ == '__main__':
    print(findRestaurant(list1=["Shogun", "Tapioca Express", "Burger King", "KFC"],
                         list2=["KFC", "Shogun", "Burger King"]))
