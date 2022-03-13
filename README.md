Algorithm | Still work
========================

记录LeetCode、牛客网、部分OJ上各种算法题的解法，尽可能的对每道题实现多种解法，展现在过程中解题思路。使用Java和Python两种语言编写题解，力求得心应手。(本项目只包含题解代码，如有精彩的题目将同步更新题解说明文章到

+ [知乎](https://www.zhihu.com/people/dengbocong)
+ [CSDN](https://dengbocong.blog.csdn.net/)

所有引用内容均为学习使用，如若冒犯或侵权，立即删改

-------------------------

# 可视化界面说明 

老的目录结构可查看[这里](https://github.com/DengBoCong/Algorithm/blob/master/README_OLD.md)

+ 项目启动：需要在Python环境下启动

```
# 单线程启动
python server.py runserver

# 多线程启动
gunicorn server:app -c gunicorn.conf.py

# shell指令启动
sh run.sh
```

+ core目录下存放着核心的代码实现、题目、题解等，根据题目类别进行归类，其下面的tmp目录请忽略（保留的旧版本代码）
+ 代码目录最好使用英文命名，且其下的cpp、java、py、md文件必须与目录同命名，否则不会被解析到configs.json中，题解的md文件命名为在目录命名后加"_solution"示例：

```
TheSumOfTheTwoNumbers                                  题目所在目录
----TheSumOfTheTwoNumbers.cpp                          题目C++解法
----TheSumOfTheTwoNumbers.java                         题目Java解法
----TheSumOfTheTwoNumbers.py                           题目Python解法
----TheSumOfTheTwoNumbers.md                           题目
----TheSumOfTheTwoNumbers_solution.md                  题目解法
```

- configs.json在启动时自动生成（更新），生成可视化界面相关数据（这样有利于加速访问，而不必每次访问时处理）。生成的可视化界面菜单是根据题目的md文件（譬如上述的TheSumOfTheTwoNumbers.md）配置生成的，并不是根据目录结构生成，配置规则如下：

```
$=title=$: 标题
$=class=$: 分类
$=origin=$: 题目来源
$=degree=$: 题目难度，Hard/Medium/Easy
$=link=$: 题目原题链接
```

# 题目列表

1.[有序数组中的单一元素](https://leetcode-cn.com/problems/single-element-in-a-sorted-array/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SingleElementInASortedArray/SingleElementInASortedArray.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SingleElementInASortedArray/SingleElementInASortedArray.py)）：题目难度(中等)，题目类型(数组_二分查找)

2.[矩阵中的幸运数](https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LuckyNumbersInAMatrix/LuckyNumbersInAMatrix.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LuckyNumbersInAMatrix/LuckyNumbersInAMatrix.py)）：题目难度(简单)，题目类型(数组_矩阵)

3.[适合打劫银行的日子](https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindGoodDaysToRobTheBank/FindGoodDaysToRobTheBank.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindGoodDaysToRobTheBank/FindGoodDaysToRobTheBank.py)）：题目难度(中等)，题目类型(数组_动态规划_前缀和)

4.[最长特殊序列 Ⅰ](https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestUncommonSubsequenceI/LongestUncommonSubsequenceI.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestUncommonSubsequenceI/LongestUncommonSubsequenceI.py)）：题目难度(简单)，题目类型(字符串)

5.[最长特殊序列 II](https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestUncommonSubsequenceII/LongestUncommonSubsequenceII.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestUncommonSubsequenceII/LongestUncommonSubsequenceII.py)）：题目难度(中等)，题目类型(数组_哈希表_双指针_字符串_排序)

6.[七进制数](https://leetcode-cn.com/problems/base-7/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Base7/Base7.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Base7/Base7.py)）：题目难度(简单)，题目类型(数学)

7.[子数组范围和](https://leetcode-cn.com/problems/sum-of-subarray-ranges/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SumOfSubarrayRanges/SumOfSubarrayRanges.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SumOfSubarrayRanges/SumOfSubarrayRanges.py)）：题目难度(中等)，题目类型(栈_数组_单调栈)

8.[蜡烛之间的盘子](https://leetcode-cn.com/problems/plates-between-candles/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/PlatesBetweenCandles/PlatesBetweenCandles.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/PlatesBetweenCandles/PlatesBetweenCandles.py)）：题目难度(中等)，题目类型(数组_字符串_二分查找_前缀和)

9.[各位相加](https://leetcode-cn.com/problems/add-digits/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AddDigits/AddDigits.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AddDigits/AddDigits.py)）：题目难度(简单)，题目类型(数学_数论_模拟)

10.[快乐数](https://leetcode-cn.com/problems/happy-number/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/HappyNumber/HappyNumber.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/HappyNumber/HappyNumber.py)）：题目难度(简单)，题目类型(哈希表_数学_双指针)

11.[得分最高的最小轮调](https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SmallestRotationWithHighestScore/SmallestRotationWithHighestScore.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SmallestRotationWithHighestScore/SmallestRotationWithHighestScore.py)）：题目难度(困难)，题目类型(数组_前缀和)

12.[N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NAryTreePreorderTraversal/NAryTreePreorderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NAryTreePreorderTraversal/NAryTreePreorderTraversal.py)）：题目难度(简单)，题目类型(栈_树_深度优先搜索)

13.[二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreePreorderTraversal/BinaryTreePreorderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreePreorderTraversal/BinaryTreePreorderTraversal.py)）：题目难度(简单)，题目类型(栈_树_深度优先搜索_二叉树)

14.[二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeInorderTraversal/BinaryTreeInorderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeInorderTraversal/BinaryTreeInorderTraversal.py)）：题目难度(简单)，题目类型(栈_树_深度优先搜索_二叉树)

15.[二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreePostorderTraversal/BinaryTreePostorderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreePostorderTraversal/BinaryTreePostorderTraversal.py)）：题目难度(简单)，题目类型(栈_树_深度优先搜索_二叉树)

16.[N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NAryTreePostorderTraversal/NAryTreePostorderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NAryTreePostorderTraversal/NAryTreePostorderTraversal.py)）：题目难度(简单)，题目类型(栈_树_深度优先搜索)

17.[N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NAryTreeLevelOrderTraversal/NAryTreeLevelOrderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NAryTreeLevelOrderTraversal/NAryTreeLevelOrderTraversal.py)）：题目难度(中等)，题目类型(树_广度优先搜索)

18.[统计最高分的节点数目](https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountNodesWithTheHighestScore/CountNodesWithTheHighestScore.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountNodesWithTheHighestScore/CountNodesWithTheHighestScore.py)）：题目难度(中等)，题目类型(树_深度优先搜索_数组_二叉树)

19.[寻找最近的回文数](https://leetcode-cn.com/problems/find-the-closest-palindrome/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindTheClosestPalindrome/FindTheClosestPalindrome.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindTheClosestPalindrome/FindTheClosestPalindrome.py)）：题目难度(困难)，题目类型(数学_字符串)

20.[Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ZigzagConversion/ZigzagConversion.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ZigzagConversion/ZigzagConversion.py)）：题目难度(中等)，题目类型(字符串)

21.[UTF-8 编码验证](https://leetcode-cn.com/problems/utf-8-validation/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Utf8Validation/Utf8Validation.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Utf8Validation/Utf8Validation.py)）：题目难度(中等)，题目类型(位运算_数组)

22.[最多可达成的换楼请求数目](https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumNumberOfAchievableTransferRequests/MaximumNumberOfAchievableTransferRequests.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumNumberOfAchievableTransferRequests/MaximumNumberOfAchievableTransferRequests.py)）：题目难度(困难)，题目类型(位运算_数组_回溯_枚举)

