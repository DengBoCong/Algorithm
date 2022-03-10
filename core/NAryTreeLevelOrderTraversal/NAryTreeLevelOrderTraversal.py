from queue import Queue
from typing import List

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

def levelOrder(root: 'Node') -> List[List[int]]:
    if root == None:
        return []
    res, remain, level = [], Queue(), 1
    remain.put((level, root))
    while not remain.empty():
        node = remain.get()
        level = node[0]
        if len(res) < level:
            res.append([])
        res[level - 1].append(node[1].val)
        for item in node[1].children:
            remain.put((level + 1, item))

    return res

if __name__ == '__main__':
    levelOrder("re")
