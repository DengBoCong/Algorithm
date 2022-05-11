class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:
    def serialize(self, root: TreeNode) -> str:
        """Encodes a tree to a single string.
        """
        res = []

        def dfs(node):
            if not node:
                return
            dfs(node.left)
            dfs(node.right)
            res.append(str(node.val))

        dfs(root)

        return " ".join(res)

    def deserialize(self, data: str) -> TreeNode:
        """Decodes your encoded data to tree.
        """
        back_tree = list(map(int, data.split()))

        def dfs(lower, upper):
            if len(back_tree) == 0 or back_tree[-1] < lower or back_tree[-1] > upper:
                return None
            root_val = back_tree.pop()
            root = TreeNode(root_val)
            root.right = dfs(root_val, upper)
            root.left = dfs(lower, root_val)
            return root

        return dfs(float("-inf"), float("inf"))




