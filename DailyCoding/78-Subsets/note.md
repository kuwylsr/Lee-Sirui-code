# 78-子集

## [题目](https://leetcode-cn.com/problems/subsets/)(难度中等)

给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

```markdown
示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

```

### 算法知识点
1. 此题的第一种解法依然是利用回溯(递归形式)，他与前面做的 `46` 题不同的是，他的解空间，不需要每次都遍历所有的 nums 数组，因此，在参数传递的时候，需要传入一个 j 来控制从 nums 数组的那里开始遍历。

2. 采用。。