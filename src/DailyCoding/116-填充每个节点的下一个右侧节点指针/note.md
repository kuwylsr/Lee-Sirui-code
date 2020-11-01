# 116-填充每个节点的下一个右侧节点指针

## [题目](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)(难度中等)

给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

```C++
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

![image](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/15/116_sample.png)

提示：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

### 算法知识点
1. 本人采用的是 用队列实现的广度优先搜索，空间复杂度不是常数级别

2. 通过利用指针来实现常数级别的广度优先搜索，见第三种方法

3. 递归形式的解法见第二种方法