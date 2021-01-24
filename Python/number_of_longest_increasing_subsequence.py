def findNumberOfLIS_dp(nums: list) -> int:
    length = len(nums)
    if length <= 1:
        return length

    lengths = [0] * length
    counts = [1] * length

    for j, num in enumerate(nums):
        for i in range(j):
            if nums[i] < nums[j]:
                if lengths[i] >= lengths[j]:
                    lengths[j] = 1 + lengths[i]
                    counts[j] = counts[i]
                elif lengths[i] + 1 == lengths[j]:
                    counts[j] += counts[i]

    longest = max(lengths)
    return sum(c for i, c in enumerate(counts) if lengths[i] == longest)


class Node(object):
    def __init__(self, start, end):
        self.range_left, self.range_right = start, end
        self._left = self._right = None
        self.val = 0, 1 #length, count
    @property
    def range_mid(self):
        return (self.range_left + self.range_right) / 2
    @property
    def left(self):
        self._left = self._left or Node(self.range_left, self.range_mid)
        return self._left
    @property
    def right(self):
        self._right = self._right or Node(self.range_mid + 1, self.range_right)
        return self._right

def merge(v1, v2):
    if v1[0] == v2[0]:
        if v1[0] == 0: return (0, 1)
        return v1[0], v1[1] + v2[1]
    return max(v1, v2)

def insert(node, key, val):
    if node.range_left == node.range_right:
        node.val = merge(val, node.val)
        return
    if key <= node.range_mid:
        insert(node.left, key, val)
    else:
        insert(node.right, key, val)
    node.val = merge(node.left.val, node.right.val)

def query(node, key):
    if node.range_right <= key:
        return node.val
    elif node.range_left > key:
        return 0, 1
    else:
        return merge(query(node.left, key), query(node.right, key))


def findNumberOfLIS_tree(nums: list) -> int:
    if not nums: return 0
    root = Node(min(nums), max(nums))
    for num in nums:
        length, count = query(root, num-1)
        insert(root, num, (length+1, count))
    return root.val[1]


if __name__ == "__main__":
    print(findNumberOfLIS_tree([2, 2, 2, 2, 2]))
