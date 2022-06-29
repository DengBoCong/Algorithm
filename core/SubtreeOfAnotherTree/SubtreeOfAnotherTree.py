class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def isSubtree(root: TreeNode, subRoot: TreeNode) -> bool:
    res = False

    def dfs(node: TreeNode, flag: str):
        nonlocal res
        if not node:
            return "None"
        left_str = dfs(node.left, flag)
        right_str = dfs(node.right, flag)
        node_str = f"l{left_str}|{node.val}|r{right_str}"
        if flag and node_str == flag:
            res = True
        return node_str

    sub_str = dfs(subRoot, None)
    dfs(root, sub_str)
    return res
