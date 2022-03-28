class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def lowestCommonAncestor(root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    parents, visited = {}, {}
    def dfs(node):
        if node.left:
            parents[node.left.val] = node
            dfs(node.left)
        if node.right:
            parents[node.right.val] = node
            dfs(node.right)

    dfs(root)
    while p:
        visited[p.val] = True
        p = parents.get(p.val)
    while q:
        if visited.get(q.val, False):
            return q
        q = parents.get(q.val)

    return None



