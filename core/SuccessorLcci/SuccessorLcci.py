class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def inorderSuccessor(root: TreeNode, p: TreeNode) -> TreeNode:
    queue, pre_node, cur_node = [], None, root
    while queue or cur_node:
        while cur_node:
            queue.append(cur_node)
            cur_node = cur_node.left
        cur_node = queue.pop()
        if pre_node == p:
            return cur_node
        pre_node = cur_node
        cur_node = cur_node.right

    return None
