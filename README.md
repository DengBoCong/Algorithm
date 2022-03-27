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

23.[两个列表的最小索引总和](https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumIndexSumOfTwoLists/MinimumIndexSumOfTwoLists.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumIndexSumOfTwoLists/MinimumIndexSumOfTwoLists.py)）：题目难度(简单)，题目类型(数组_哈希表_字符串)

24.[相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/IntersectionOfTwoLinkedLists/IntersectionOfTwoLinkedLists.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/IntersectionOfTwoLinkedLists/IntersectionOfTwoLinkedLists.py)）：题目难度(简单)，题目类型(哈希表_链表_双指针)

25.[统计按位或能得到最大值的子集数目](https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountNumberOfMaximumBitwiseOrSubsets/CountNumberOfMaximumBitwiseOrSubsets.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountNumberOfMaximumBitwiseOrSubsets/CountNumberOfMaximumBitwiseOrSubsets.py)）：题目难度(中等)，题目类型(位运算_数组_回溯)

26.[最优除法](https://leetcode-cn.com/problems/optimal-division/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/OptimalDivision/OptimalDivision.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/OptimalDivision/OptimalDivision.py)）：题目难度(中等)，题目类型(数组_数学_动态规划)

27.[增量元素之间的最大差值](https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumDifferenceBetweenIncreasingElements/MaximumDifferenceBetweenIncreasingElements.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumDifferenceBetweenIncreasingElements/MaximumDifferenceBetweenIncreasingElements.py)）：题目难度(简单)，题目类型(数组)

28.[复数乘法](https://leetcode-cn.com/problems/complex-number-multiplication/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ComplexNumberMultiplication/ComplexNumberMultiplication.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ComplexNumberMultiplication/ComplexNumberMultiplication.py)）：题目难度(中等)，题目类型(数学_字符串_模拟)

29.[全 O(1) 的数据结构](https://leetcode-cn.com/problems/all-oone-data-structure/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AllOoneDataStructure/AllOoneDataStructure.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AllOoneDataStructure/AllOoneDataStructure.py)）：题目难度(困难)，题目类型(设计_哈希表_链表_双向链表)

30.[球会落何处](https://leetcode-cn.com/problems/where-will-the-ball-fall/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/WhereWillTheBallFall/WhereWillTheBallFall.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/WhereWillTheBallFall/WhereWillTheBallFall.py)）：题目难度(中等)，题目类型(深度优先搜索_数组_动态规划_矩阵_模拟)

31.[仅仅反转字母](https://leetcode-cn.com/problems/reverse-only-letters/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseOnlyLetters/ReverseOnlyLetters.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseOnlyLetters/ReverseOnlyLetters.py)）：题目难度(简单)，题目类型(双指针_字符串)

32.[计数质数](https://leetcode-cn.com/problems/count-primes/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountPrimes/CountPrimes.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountPrimes/CountPrimes.py)）：题目难度(中等)，题目类型(数组_数学_枚举_数论)

33.[词典中最长的单词](https://leetcode-cn.com/problems/longest-word-in-dictionary/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestWordInDictionary/LongestWordInDictionary.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestWordInDictionary/LongestWordInDictionary.py)）：题目难度(简单)，题目类型(字典树_数组_哈希表_字符串_排序)

34.[通过删除字母匹配到字典里最长单词](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestWordInDictionaryThroughDeleting/LongestWordInDictionaryThroughDeleting.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestWordInDictionaryThroughDeleting/LongestWordInDictionaryThroughDeleting.py)）：题目难度(中等)，题目类型(数组_双指针_字符串_排序)

35.[实现一个魔法字典](https://leetcode-cn.com/problems/implement-magic-dictionary/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ImplementMagicDictionary/ImplementMagicDictionary.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ImplementMagicDictionary/ImplementMagicDictionary.py)）：题目难度(中等)，题目类型(设计_字典树_哈希表_字符串)

36.[简易银行系统](https://leetcode-cn.com/problems/simple-bank-system/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SimpleBankSystem/SimpleBankSystem.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SimpleBankSystem/SimpleBankSystem.py)）：题目难度(中等)，题目类型(设计_数组_哈希表_模拟)

37.[学生分数的最小差值](https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumDifferenceBetweenHighestAndLowestOfKScores/MinimumDifferenceBetweenHighestAndLowestOfKScores.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumDifferenceBetweenHighestAndLowestOfKScores/MinimumDifferenceBetweenHighestAndLowestOfKScores.py)）：题目难度(简单)，题目类型(数组_排序_滑动窗口)

38.[根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ConstructStringFromBinaryTree/ConstructStringFromBinaryTree.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ConstructStringFromBinaryTree/ConstructStringFromBinaryTree.py)）：题目难度(简单)，题目类型(树_深度优先搜索_字符串_二叉树)

39.[寻找重复的子树](https://leetcode-cn.com/problems/find-duplicate-subtrees/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindDuplicateSubtrees/FindDuplicateSubtrees.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindDuplicateSubtrees/FindDuplicateSubtrees.py)）：题目难度(中等)，题目类型(树_深度优先搜索_哈希表_二叉树)

40.[最长的美好子字符串](https://leetcode-cn.com/problems/longest-nice-substring/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestNiceSubstring/LongestNiceSubstring.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestNiceSubstring/LongestNiceSubstring.py)）：题目难度(简单)，题目类型(位运算_哈希表_字符串_滑动窗口)

41.[至少有 K 个重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ZhiShaoYouKgeZhongFuZiFuDeZuiCO6ww/ZhiShaoYouKgeZhongFuZiFuDeZuiCO6ww.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ZhiShaoYouKgeZhongFuZiFuDeZuiCO6ww/ZhiShaoYouKgeZhongFuZiFuDeZuiCO6ww.py)）：题目难度(中等)，题目类型(哈希表_字符串_分治_滑动窗口)

42.[网络空闲的时刻](https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TheTimeWhenTheNetworkBecomesIdle/TheTimeWhenTheNetworkBecomesIdle.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TheTimeWhenTheNetworkBecomesIdle/TheTimeWhenTheNetworkBecomesIdle.py)）：题目难度(中等)，题目类型(广度优先搜索_图_数组)

43.[切棍子的最小成本](https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumCostToCutAStick/MinimumCostToCutAStick.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumCostToCutAStick/MinimumCostToCutAStick.py)）：题目难度(困难)，题目类型(数组_动态规划)

44.[两数之和 IV - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TwoSumIvInputIsABst/TwoSumIvInputIsABst.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TwoSumIvInputIsABst/TwoSumIvInputIsABst.py)）：题目难度(简单)，题目类型(树_深度优先搜索_广度优先搜索_二叉搜索树_哈希表_双指针_二叉树)

45.[两数之和](https://leetcode-cn.com/problems/two-sum/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TwoSum/TwoSum.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TwoSum/TwoSum.py)）：题目难度(简单)，题目类型(数组_哈希表)

46.[如果相邻两个颜色均相同则删除当前颜色](https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RemoveColoredPiecesIfBothNeighborsAreTheSameColor/RemoveColoredPiecesIfBothNeighborsAreTheSameColor.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RemoveColoredPiecesIfBothNeighborsAreTheSameColor/RemoveColoredPiecesIfBothNeighborsAreTheSameColor.py)）：题目难度(中等)，题目类型(贪心_数学_字符串_博弈)

46.[字符串的最大公因子](https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/GreatestCommonDivisorOfStrings/GreatestCommonDivisorOfStrings.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/GreatestCommonDivisorOfStrings/GreatestCommonDivisorOfStrings.py)）：题目难度(简单)，题目类型(数学_字符串)

47.[两数相加](https://leetcode-cn.com/problems/add-two-numbers/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AddTwoNumbers/AddTwoNumbers.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AddTwoNumbers/AddTwoNumbers.py)）：题目难度(中等)，题目类型(递归_链表_数学)

48.[字典序的第K小数字](https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/KThSmallestInLexicographicalOrder/KThSmallestInLexicographicalOrder.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/KThSmallestInLexicographicalOrder/KThSmallestInLexicographicalOrder.py)）：题目难度(困难)，题目类型(字典树)

49.[反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseLinkedList/ReverseLinkedList.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseLinkedList/ReverseLinkedList.py)）：题目难度(简单)，题目类型(递归_链表)

50.[无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestSubstringWithoutRepeatingCharacters/LongestSubstringWithoutRepeatingCharacters.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestSubstringWithoutRepeatingCharacters/LongestSubstringWithoutRepeatingCharacters.py)）：题目难度(中等)，题目类型(哈希表_字符串_滑动窗口)

51.[图片平滑器](https://leetcode-cn.com/problems/image-smoother/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ImageSmoother/ImageSmoother.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ImageSmoother/ImageSmoother.py)）：题目难度(简单)，题目类型(数组_矩阵)

52.[LRU 缓存](https://leetcode-cn.com/problems/lru-cache/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LruCache/LruCache.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LruCache/LruCache.py)）：题目难度(中等)，题目类型(设计_哈希表_链表_双向链表)

53.[数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/KthLargestElementInAnArray/KthLargestElementInAnArray.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/KthLargestElementInAnArray/KthLargestElementInAnArray.py)）：题目难度(中等)，题目类型(数组_分治_快速选择_排序_堆（优先队列）)

54.[阶乘后的零](https://leetcode-cn.com/problems/factorial-trailing-zeroes/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FactorialTrailingZeroes/FactorialTrailingZeroes.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FactorialTrailingZeroes/FactorialTrailingZeroes.py)）：题目难度(中等)，题目类型(数学)

55.[K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseNodesInKGroup/ReverseNodesInKGroup.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseNodesInKGroup/ReverseNodesInKGroup.py)）：题目难度(困难)，题目类型(递归_链表)

56.[三数之和](https://leetcode-cn.com/problems/3sum/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/3Sum/3Sum.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/3Sum/3Sum.py)）：题目难度(中等)，题目类型(数组_双指针_排序)

57.[棒球比赛](https://leetcode-cn.com/problems/baseball-game/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BaseballGame/BaseballGame.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BaseballGame/BaseballGame.py)）：题目难度(简单)，题目类型(栈_数组_模拟)

58.[排序数组](https://leetcode-cn.com/problems/sort-an-array/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SortAnArray/SortAnArray.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SortAnArray/SortAnArray.py)）：题目难度(中等)，题目类型(数组_分治_桶排序_计数排序_快速排序_堆排序_归并排序)

59.[找出缺失的观测数据](https://leetcode-cn.com/problems/find-missing-observations/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindMissingObservations/FindMissingObservations.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindMissingObservations/FindMissingObservations.py)）：题目难度(中等)，题目类型(数组_数学_模拟)

60.[最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumSubarray/MaximumSubarray.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumSubarray/MaximumSubarray.py)）：题目难度(简单)，题目类型(数组_分治_动态规划)

61.[合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeTwoSortedLists/MergeTwoSortedLists.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeTwoSortedLists/MergeTwoSortedLists.py)）：题目难度(简单)，题目类型(递归_链表)

62.[二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeLevelOrderTraversal/BinaryTreeLevelOrderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeLevelOrderTraversal/BinaryTreeLevelOrderTraversal.py)）：题目难度(中等)，题目类型(数_广度优先搜索_二叉树)

63.[环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LinkedListCycle/LinkedListCycle.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LinkedListCycle/LinkedListCycle.py)）：题目难度(简单)，题目类型(哈希表_链表_双指针)

64.[买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BestTimeToBuyAndSellStock/BestTimeToBuyAndSellStock.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BestTimeToBuyAndSellStock/BestTimeToBuyAndSellStock.py)）：题目难度(简单)，题目类型(数组_动态规划)

65.[二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeZigzagLevelOrderTraversal/BinaryTreeZigzagLevelOrderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeZigzagLevelOrderTraversal/BinaryTreeZigzagLevelOrderTraversal.py)）：题目难度(中等)，题目类型(数_广度优先搜索_二叉树)

66.[合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeSortedArray/MergeSortedArray.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeSortedArray/MergeSortedArray.py)）：题目难度(简单)，题目类型(数组_双指针_排序)

67.[有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ValidParentheses/ValidParentheses.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ValidParentheses/ValidParentheses.py)）：题目难度(简单)，题目类型(栈_字符串)

