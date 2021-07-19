class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

def copyRandomList(self, head: 'Node') -> 'Node':
    def dfs(head):
        if not head: return None
        if head in visited:
            return visited[head]
        # 创建新结点
        copy = Node(head.val, None, None)
        visited[head] = copy
        copy.next = dfs(head.next)
        copy.random = dfs(head.random)
        return copy
    visited = {}
    return dfs(head)