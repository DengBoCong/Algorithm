import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def findDuplicateSubtrees_dfs(root: TreeNode) -> list:
    count = collections.Counter()
    ans = []
    def collect(node):
        if not node: return "#"
        serial = "{},{},{}".format(node.val, collect(node.left), collect(node.right))
        count[serial] += 1
        if count[serial] == 2:
            ans.append(node)
        return serial
    
    collect(root)
    return ans

def findDuplicateSubtrees_uid(root: TreeNode) -> list:
    trees = collections.defaultdict()
    trees.default_factory = trees.__len__
    count = collections.Counter()
    ans = []
    def lookup(node):
        if node:
            uid = trees[node.val, lookup(node.left), lookup(node.right)]
            count[uid] += 1
            if count[uid] == 2:
                ans.append(node)
            return uid
    lookup(root)
    return ans