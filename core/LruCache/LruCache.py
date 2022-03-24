class DLinkNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.head = DLinkNode(0, 0)
        self.tail = DLinkNode(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.map = {}

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        node = self.map[key]
        self.remove_node(node)
        self.add_to_head(node)

        return self.map[key].val

    def put(self, key: int, value: int) -> None:
        if key not in self.map:
            node = DLinkNode(key, value)
            self.add_to_head(node)
            self.map[key] = node
            self.size += 1
            if self.size > self.capacity:
                temp = self.tail.prev
                self.remove_node(temp)
                self.size -= 1
                del self.map[temp.key]
        else:
            node = self.map[key]
            node.val = value
            self.remove_node(node)
            self.add_to_head(node)

    def remove_node(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def add_to_head(self, node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node
