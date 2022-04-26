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

68.[交替位二进制数](https://leetcode-cn.com/problems/binary-number-with-alternating-bits/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryNumberWithAlternatingBits/BinaryNumberWithAlternatingBits.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryNumberWithAlternatingBits/BinaryNumberWithAlternatingBits.py)）：题目难度(简单)，题目类型(位运算)

69.[二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LowestCommonAncestorOfABinaryTree/LowestCommonAncestorOfABinaryTree.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LowestCommonAncestorOfABinaryTree/LowestCommonAncestorOfABinaryTree.py)）：题目难度(中等)，题目类型(数_深度优先搜索_二叉树)

70.[最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestPalindromicSubstring/LongestPalindromicSubstring.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestPalindromicSubstring/LongestPalindromicSubstring.py)）：题目难度(中等)，题目类型(字符串_动态规划)

71.[搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SearchInRotatedSortedArray/SearchInRotatedSortedArray.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SearchInRotatedSortedArray/SearchInRotatedSortedArray.py)）：题目难度(中等)，题目类型(数组_二分查找)

72.[考试的最大困扰度](https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximizeTheConfusionOfAnExam/MaximizeTheConfusionOfAnExam.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximizeTheConfusionOfAnExam/MaximizeTheConfusionOfAnExam.py)）：题目难度(中等)，题目类型(字符串_二分查找_前缀和_滑动窗口)

73.[岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NumberOfIslands/NumberOfIslands.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NumberOfIslands/NumberOfIslands.py)）：题目难度(中等)，题目类型(深度优先搜索_广度优先搜索_并查集_数组_矩阵)

74.[全排列](https://leetcode-cn.com/problems/permutations/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Permutations/Permutations.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Permutations/Permutations.py)）：题目难度(中等)，题目类型(数组_回溯)

75.[字符串相加](https://leetcode-cn.com/problems/add-strings/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AddStrings/AddStrings.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/AddStrings/AddStrings.py)）：题目难度(简单)，题目类型(数学_字符串_模拟)

76.[找到处理最多请求的服务器](https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindServersThatHandledMostNumberOfRequests/FindServersThatHandledMostNumberOfRequests.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindServersThatHandledMostNumberOfRequests/FindServersThatHandledMostNumberOfRequests.py)）：题目难度(困难)，题目类型(贪心_数组_有序集合_堆（优先队列）)

77.[合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeKSortedLists/MergeKSortedLists.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeKSortedLists/MergeKSortedLists.py)）：题目难度(困难)，题目类型(链表_分治_堆（优先队列）_归并排序)

78.[自除数](https://leetcode-cn.com/problems/self-dividing-numbers/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SelfDividingNumbers/SelfDividingNumbers.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SelfDividingNumbers/SelfDividingNumbers.py)）：题目难度(简单)，题目类型(数学)

79.[反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseLinkedListII/ReverseLinkedListII.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseLinkedListII/ReverseLinkedListII.py)）：题目难度(中等)，题目类型(链表)

80.[螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SpiralMatrix/SpiralMatrix.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SpiralMatrix/SpiralMatrix.py)）：题目难度(中等)，题目类型(数学_矩阵_模拟)

81.[二倍数对数组](https://leetcode-cn.com/problems/array-of-doubled-pairs/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ArrayOfDoubledPairs/ArrayOfDoubledPairs.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ArrayOfDoubledPairs/ArrayOfDoubledPairs.py)）：题目难度(中等)，题目类型(贪心_数组_哈希表_排序)

82.[最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestIncreasingSubsequence/LongestIncreasingSubsequence.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestIncreasingSubsequence/LongestIncreasingSubsequence.py)）：题目难度(中等)，题目类型(数组_二分查找_动态规划)

83.[接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TrappingRainWater/TrappingRainWater.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/TrappingRainWater/TrappingRainWater.py)）：题目难度(困难)，题目类型(栈_数组_双指针_动态规划_单调栈)

84.[二分查找](https://leetcode-cn.com/problems/binary-search/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinarySearch/BinarySearch.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinarySearch/BinarySearch.py)）：题目难度(简单)，题目类型(数组_二分查找)

85.[重排链表](https://leetcode-cn.com/problems/reorder-list/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReorderList/ReorderList.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReorderList/ReorderList.py)）：题目难度(中等)，题目类型(栈_递归_链表_双指针)

86.[强密码检验器](https://leetcode-cn.com/problems/strong-password-checker/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/StrongPasswordChecker/StrongPasswordChecker.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/StrongPasswordChecker/StrongPasswordChecker.py)）：题目难度(困难)，题目类型(贪心_字符串_堆（优先队列）)

87.[用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ImplementQueueUsingStacks/ImplementQueueUsingStacks.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ImplementQueueUsingStacks/ImplementQueueUsingStacks.py)）：题目难度(简单)，题目类型(栈_设计_队列)

88.[二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeMaximumPathSum/BinaryTreeMaximumPathSum.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeMaximumPathSum/BinaryTreeMaximumPathSum.py)）：题目难度(困难)，题目类型(树_深度优先搜索_动态规划_二叉树)

89.[二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeRightSideView/BinaryTreeRightSideView.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BinaryTreeRightSideView/BinaryTreeRightSideView.py)）：题目难度(中等)，题目类型(树_深度优先搜索_广度优先搜索_二叉树)

90.[爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ClimbingStairs/ClimbingStairs.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ClimbingStairs/ClimbingStairs.py)）：题目难度(简单)，题目类型(记忆化搜索_数学_动态规划)

91.[最小高度树](https://leetcode-cn.com/problems/minimum-height-trees/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumHeightTrees/MinimumHeightTrees.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumHeightTrees/MinimumHeightTrees.py)）：题目难度(中等)，题目类型(深度优先搜索_广度优先搜索_图_拓扑排序)

92.[旋转字符串](https://leetcode-cn.com/problems/rotate-string/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RotateString/RotateString.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RotateString/RotateString.py)）：题目难度(简单)，题目类型(字符串_字符串匹配)

93.[到达终点](https://leetcode-cn.com/problems/reaching-points/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReachingPoints/ReachingPoints.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReachingPoints/ReachingPoints.py)）：题目难度(困难)，题目类型(数学)

93.[搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SearchInRotatedSortedArrayII/SearchInRotatedSortedArrayII.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SearchInRotatedSortedArrayII/SearchInRotatedSortedArrayII.py)）：题目难度(中等)，题目类型(数组_二分查找)

94.[寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindMinimumInRotatedSortedArray/FindMinimumInRotatedSortedArray.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FindMinimumInRotatedSortedArray/FindMinimumInRotatedSortedArray.py)）：题目难度(中等)，题目类型(数组_二分查找)

95.[删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RemoveNthNodeFromEndOfList/RemoveNthNodeFromEndOfList.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RemoveNthNodeFromEndOfList/RemoveNthNodeFromEndOfList.py)）：题目难度(中等)，题目类型(链表_双指针)

96.[x 的平方根](https://leetcode-cn.com/problems/sqrtx/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Sqrtx/Sqrtx.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Sqrtx/Sqrtx.py)）：题目难度(简单)，题目类型(数学_二分查找)

97.[删除排序链表中的重复元素 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RemoveDuplicatesFromSortedListII/RemoveDuplicatesFromSortedListII.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RemoveDuplicatesFromSortedListII/RemoveDuplicatesFromSortedListII.py)）：题目难度(中等)，题目类型(链表_双指针)

98.[唯一摩尔斯密码词](https://leetcode-cn.com/problems/unique-morse-code-words/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/UniqueMorseCodeWords/UniqueMorseCodeWords.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/UniqueMorseCodeWords/UniqueMorseCodeWords.py)）：题目难度(简单)，题目类型(数组_哈希表_字符串)

99.[合并区间](https://leetcode-cn.com/problems/merge-intervals/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeIntervals/MergeIntervals.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MergeIntervals/MergeIntervals.py)）：题目难度(中等)，题目类型(数组_排序)

100.[编辑距离](https://leetcode-cn.com/problems/edit-distance/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/EditDistance/EditDistance.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/EditDistance/EditDistance.py)）：题目难度(中等)，题目类型(数组_排序)

101.[寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MedianOfTwoSortedArrays/MedianOfTwoSortedArrays.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MedianOfTwoSortedArrays/MedianOfTwoSortedArrays.py)）：题目难度(困难)，题目类型(数组_二分查找_分治)

102.[统计各位数字都不同的数字个数](https://leetcode-cn.com/problems/count-numbers-with-unique-digits/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountNumbersWithUniqueDigits/CountNumbersWithUniqueDigits.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CountNumbersWithUniqueDigits/CountNumbersWithUniqueDigits.py)）：题目难度(中等)，题目类型(数学_动态规划_回溯)

103.[字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/StringToIntegerAtoi/StringToIntegerAtoi.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/StringToIntegerAtoi/StringToIntegerAtoi.py)）：题目难度(中等)，题目类型(字符串)

104.[排序链表](https://leetcode-cn.com/problems/sort-list/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SortList/SortList.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SortList/SortList.py)）：题目难度(中等)，题目类型(链表_双指针_分治_排序_归并排序)

105.[写字符串需要的行数](https://leetcode-cn.com/problems/number-of-lines-to-write-string/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NumberOfLinesToWriteString/NumberOfLinesToWriteString.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NumberOfLinesToWriteString/NumberOfLinesToWriteString.py)）：题目难度(简单)，题目类型(数组_字符串)

106.[链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LianBiaoZhongDaoShuDiKgeJieDianLcof/LianBiaoZhongDaoShuDiKgeJieDianLcof.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LianBiaoZhongDaoShuDiKgeJieDianLcof/LianBiaoZhongDaoShuDiKgeJieDianLcof.py)）：题目难度(简单)，题目类型(链表_双指针)

107.[最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestCommonSubsequence/LongestCommonSubsequence.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestCommonSubsequence/LongestCommonSubsequence.py)）：题目难度(中等)，题目类型(字符串_动态规划)

108.[括号生成](https://leetcode-cn.com/problems/generate-parentheses/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/GenerateParentheses/GenerateParentheses.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/GenerateParentheses/GenerateParentheses.py)）：题目难度(中等)，题目类型(字符串_动态规划_回溯)

109.[O(1) 时间插入、删除和获取随机元素](https://leetcode-cn.com/problems/insert-delete-getrandom-o1/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/InsertDeleteGetrandomO1/InsertDeleteGetrandomO1.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/InsertDeleteGetrandomO1/InsertDeleteGetrandomO1.py)）：题目难度(中等)，题目类型(设计_数组_哈希表_数学_随机化)

110.[缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FirstMissingPositive/FirstMissingPositive.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/FirstMissingPositive/FirstMissingPositive.py)）：题目难度(困难)，题目类型(数组_哈希表)

111.[下一个排列](https://leetcode-cn.com/problems/next-permutation/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NextPermutation/NextPermutation.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/NextPermutation/NextPermutation.py)）：题目难度(中等)，题目类型(数组_双指针)

112.[最富有客户的资产总量](https://leetcode-cn.com/problems/richest-customer-wealth/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RichestCustomerWealth/RichestCustomerWealth.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RichestCustomerWealth/RichestCustomerWealth.py)）：题目难度(简单)，题目类型(数组_矩阵)

113.[颠倒字符串中的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseWordsInAString/ReverseWordsInAString.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ReverseWordsInAString/ReverseWordsInAString.py)）：题目难度(中等)，题目类型(双指针_字符串)

114.[复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RestoreIpAddresses/RestoreIpAddresses.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RestoreIpAddresses/RestoreIpAddresses.py)）：题目难度(中等)，题目类型(字符串_回溯)

115.[从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ConstructBinaryTreeFromPreorderAndInorderTraversal/ConstructBinaryTreeFromPreorderAndInorderTraversal.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ConstructBinaryTreeFromPreorderAndInorderTraversal/ConstructBinaryTreeFromPreorderAndInorderTraversal.py)）：题目难度(中等)，题目类型(树_数组_哈希表_分治_二叉树)

116.[最大回文数乘积](https://leetcode-cn.com/problems/largest-palindrome-product/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LargestPalindromeProduct/LargestPalindromeProduct.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LargestPalindromeProduct/LargestPalindromeProduct.py)）：题目难度(困难)，题目类型(数学)

117.[滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SlidingWindowMaximum/SlidingWindowMaximum.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SlidingWindowMaximum/SlidingWindowMaximum.py)）：题目难度(困难)，题目类型(队列_数组_滑动窗口_单调队列_堆（优先队列）)

118.[最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumWindowSubstring/MinimumWindowSubstring.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinimumWindowSubstring/MinimumWindowSubstring.py)）：题目难度(困难)，题目类型(哈希表_字符串_滑动窗口)

119.[平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BalancedBinaryTree/BalancedBinaryTree.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/BalancedBinaryTree/BalancedBinaryTree.py)）：题目难度(简单)，题目类型(树_深度优先搜索_二叉树)

120.[二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumDepthOfBinaryTree/MaximumDepthOfBinaryTree.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MaximumDepthOfBinaryTree/MaximumDepthOfBinaryTree.py)）：题目难度(简单)，题目类型(树_深度优先搜索_广度优先搜索_二叉树)

121.[最常见的单词](https://leetcode-cn.com/problems/most-common-word/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MostCommonWord/MostCommonWord.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MostCommonWord/MostCommonWord.py)）：题目难度(简单)，题目类型(哈希表_字符串_计数)

122.[求根节点到叶节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SumRootToLeafNumbers/SumRootToLeafNumbers.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SumRootToLeafNumbers/SumRootToLeafNumbers.py)）：题目难度(中等)，题目类型(树_深度优先搜索_二叉树)

123.[最小栈](https://leetcode-cn.com/problems/min-stack/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinStack/MinStack.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/MinStack/MinStack.py)）：题目难度(简单)，题目类型(栈_设计)

124.[二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/DiameterOfBinaryTree/DiameterOfBinaryTree.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/DiameterOfBinaryTree/DiameterOfBinaryTree.py)）：题目难度(简单)，题目类型(树_深度优先搜索_二叉树)

125.[最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestValidParentheses/LongestValidParentheses.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestValidParentheses/LongestValidParentheses.py)）：题目难度(困难)，题目类型(栈_字符串_动态规划)

126.[字典序排数](https://leetcode-cn.com/problems/lexicographical-numbers/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LexicographicalNumbers/LexicographicalNumbers.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LexicographicalNumbers/LexicographicalNumbers.py)）：题目难度(中等)，题目类型(深度优先搜索_字典树)

127.[验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ValidateBinarySearchTree/ValidateBinarySearchTree.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ValidateBinarySearchTree/ValidateBinarySearchTree.py)）：题目难度(中等)，题目类型(树_深度优先搜索_二叉搜索树_二叉树)

128.[字符的最短距离](https://leetcode-cn.com/problems/shortest-distance-to-a-character/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ShortestDistanceToACharacter/ShortestDistanceToACharacter.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ShortestDistanceToACharacter/ShortestDistanceToACharacter.py)）：题目难度(简单)，题目类型(数组_双指针_字符串)

129.[路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/PathSumII/PathSumII.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/PathSumII/PathSumII.py)）：题目难度(中等)，题目类型(树_深度优先搜索_回溯_二叉树)

130.[对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SymmetricTree/SymmetricTree.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/SymmetricTree/SymmetricTree.py)）：题目难度(简单)，题目类型(树_深度优先搜索_广度优先搜索_二叉树)

131.[文件的最长绝对路径](https://leetcode-cn.com/problems/longest-absolute-file-path/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestAbsoluteFilePath/LongestAbsoluteFilePath.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/LongestAbsoluteFilePath/LongestAbsoluteFilePath.py)）：题目难度(中等)，题目类型(栈_深度优先搜索_字符串)

132.[随机数索引](https://leetcode-cn.com/problems/random-pick-index/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RandomPickIndex/RandomPickIndex.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/RandomPickIndex/RandomPickIndex.py)）：题目难度(中等)，题目类型(水塘抽样_哈希表_数学_随机化)

133.[三维形体投影面积](https://leetcode-cn.com/problems/projection-area-of-3d-shapes/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ProjectionAreaOf3dShapes/ProjectionAreaOf3dShapes.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/ProjectionAreaOf3dShapes/ProjectionAreaOf3dShapes.py)）：题目难度(简单)，题目类型(几何_数组_数学_矩阵)

134.[比较版本号](https://leetcode-cn.com/problems/compare-version-numbers/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CompareVersionNumbers/CompareVersionNumbers.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/CompareVersionNumbers/CompareVersionNumbers.py)）：题目难度(中等)，题目类型(双指针_字符串)

135.[子集](https://leetcode-cn.com/problems/subsets/)（[Java解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Subsets/Subsets.java) | [Python解法](https://github.com/DengBoCong/Algorithm/blob/master/core/Subsets/Subsets.py)）：题目难度(中等)，题目类型(位运算_数组_回溯)

