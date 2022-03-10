from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


def postorder(root: 'Node') -> List[int]:
    if root == None:
        return []

    res = []
    for node in root.children:
        res.extend(postorder(node))
    res.append(root.val)
    return res
