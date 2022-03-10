from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


def preorder(root: Node) -> List[int]:
    if root == None:
        return []

    res = [root.val]
    for node in root.children:
        res.extend(preorder(node))

    return res
