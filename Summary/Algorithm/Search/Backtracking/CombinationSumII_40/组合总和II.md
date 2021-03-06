# 40-组合总和II

## [题目](https://leetcode-cn.com/problems/combination-sum-ii/)(难度中等)

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

**说明:**
- 所有数字（包括目标数）都是正整数。
- 解集不能包含重复的组合。 

~~~markdown
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
~~~

### 算法知识点
1. 回溯
该题与 `39-组合总和` 的区别在于数组中有重复的元素, 因此我们需要做的额外操作就是去重. 我们可以利用排序加条件判断的形式来进行去重. 并且该题目集合中的元素最多被使用一次, 因此每次递归搜索应该从 `i+1` 开始.