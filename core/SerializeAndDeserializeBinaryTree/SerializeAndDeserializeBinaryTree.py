class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:
    def serialize(self, root):
        serial = []

        def dfs(node):
            if not node:
                serial.append("|")
                return
            serial.append(str(node.val))
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return ",".join(serial)

    def deserialize(self, data):
        serial = data.split(",")
        def dfs():
            root_val = serial.pop(0)
            if root_val == "|":
                return None
            root = TreeNode(root_val)
            if serial:
                root.left = dfs()
            if serial:
                root.right = dfs()
            return root
        return dfs()


