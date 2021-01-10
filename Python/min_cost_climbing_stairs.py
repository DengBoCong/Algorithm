class Solution(object):
    @staticmethod
    def min_cost_climbing_stairs(cost):
        """
        动态规划解法
        :type cost: List[int]
        :rtype: int
        """
        for i in range(2, len(cost)):
            cost[i] = min(cost[i] + cost[i - 1], cost[i] + cost[i - 2])
                
        return min(cost[-1], cost[-2])

if __name__ == "__main__":
    print(Solution.min_cost_climbing_stairs(cost=[1, 100, 1, 1, 1, 100, 1, 1, 100, 1]))