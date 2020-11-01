# 113-路径总和II

## [题目](https://leetcode-cn.com/problems/path-sum-ii/)(难度中等)

给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

**说明**: 叶子节点是指没有子节点的节点。

```markdown
示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

```

### 算法知识点
1. 此题，在112题的基础上，需要遍历整课树，并且返回所有可能的路径。在逻辑层面和112不同的是，需要额外保存一下节点信息即可。

2. 特别注意，在进行递归的时候，要尽量让递归函数的返回值类型为 `void`， 这样可节省很多不必要的开销。
   可以对比，`main.cpp` 中前两种方法与最后一种方法，前两种方法在测试机上时间消耗为1000ms左右，而第三种只需要20ms左右。

### 编程知识点
1. C++ vector两种添加元素函数的区别 [emplace_back() and push_back()](http://c.biancheng.net/view/6826.html)
   - 结论是，显然完成同样的操作，`push_back()` 的底层实现过程比 `emplace_back()` 更繁琐，换句话说，`emplace_back()` 的执行效率比 `push_back()` 高。因此，在实际使用时，建议大家优先选用 `emplace_back()`。