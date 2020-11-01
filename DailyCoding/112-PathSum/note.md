# 112-路径总和

## [题目](https://leetcode-cn.com/problems/path-sum/)(难度简单)

给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

**说明**: 叶子节点是指没有子节点的节点。

```markdown
示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

```

### 算法知识点
1. 该题主要会 `遍历` 二叉树即可，题解的方法确实更为简结明了，其换了一种思维方式，不是让 路径上的值累和==sum，而是每遍历一个点，都让sum-val，最后判断叶节点是否等于当前sum即可。

2. 复杂度分析
    - 时间复杂度：$O(N)$ ，其中 $N$ 是树的节点数。对每个节点访问一次。
    - 空间复杂度：$O(H)$，其中 $H$ 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 $O(N)$。平均情况下树的高度与节点数的对数正相关，空间复杂度为 $O(logN)$。
