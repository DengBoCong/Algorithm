from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def findFrequentTreeSum(root: TreeNode) -> List[int]:
    res, count = [], {}

    def dfs(node):
        nonlocal res
        if not node:
            return 0
        left_num = dfs(node.left)
        right_num = dfs(node.right)
        total = node.val + left_num + right_num
        if not res or count.get(total, 0) + 1 == count[res[0]]:
            res.append(total)
        elif count.get(total, 0) + 1 > count[res[0]]:
            res = [total]
        count[total] = count.get(total, 0) + 1

        return total

    dfs(root)
    return res


