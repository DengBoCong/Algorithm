from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def tree2str(root: Optional[TreeNode]) -> str:
    def dfs(node):
        if node is None:
            return ""
        res = f"{node.val}"
        left = dfs(node.left)
        right = dfs(node.right)
        if left == "" and right == "":
            return res
        elif right == "":
            return f"{res}({left})"
        else:
            return f"{res}({left})({right})"

    return dfs(root)
