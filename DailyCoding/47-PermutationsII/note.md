# 47-全排列

## [题目](https://leetcode-cn.com/problems/permutations-ii/)(难度中等)

给定一个可包含重复数字的序列，返回所有不重复的全排列。

```markdown
示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```
### 算法知识点
1. 此题就是在 46 题 的基础上进行剪枝，去掉那些重复的排列结果。首先，我们需要将输入的数组进行 `排序` 这样就方便了后续的去重。
有序性在去重的时候起到关键性的作用。

2. 此题去重的策略
![全排列树](https://pic.leetcode-cn.com/1600386643-uhkGmW-image.png)
- 在图中 ② 处，搜索的数也和上一次一样，但是上一次的 1 还在使用中；
- 在图中 ① 处，搜索的数也和上一次一样，但是上一次的 1 刚刚被撤销，正是因为刚被撤销，下面的搜索中还会使用到，因此会产生重复，剪掉的就应该是这样的分支。

