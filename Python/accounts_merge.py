import collections

class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))

    def union(self, index1: int, index2: int):
        self.parent[self.find(index2)] = self.find(index1)

    def find(self, index: int) -> int:
        if self.parent[index] != index:
            self.parent[index] = self.find(self.parent[index])
        return self.parent[index]

def accountsMerge(accounts: list) -> list:
    emailToIndex = dict()
    emailToName = dict()

    for account in accounts:
        name = account[0]
        for email in account[1:]:
            if email not in emailToIndex:
                emailToIndex[email] = len(emailToIndex)
                emailToName[email] = name
    
    uf = UnionFind(len(emailToIndex))
    for account in accounts:
        firstIndex = emailToIndex[account[1]]
        for email in account[2:]:
            uf.union(firstIndex, emailToIndex[email])
    
    indexToEmails = collections.defaultdict(list)
    for email, index in emailToIndex.items():
        index = uf.find(index)
        indexToEmails[index].append(email)
    
    ans = list()
    for emails in indexToEmails.values():
        ans.append([emailToName[emails[0]]] + sorted(emails))
    return ans


if __name__ == "__main__":
    print(accountsMerge([["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
                         ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]))
