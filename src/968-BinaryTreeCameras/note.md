# 968-监控二叉树

## [题目](https://leetcode-cn.com/problems/binary-tree-cameras/)(难度困难)

给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。

```markdown
示例 1：
```
![示例一](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_01.png)
```
输入：[0,0,null,0,0]
输出：1
解释：如图所示，一台摄像头足以监控所有节点。
```
    
```
示例 2：
```
![示例二](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_02.png)
```
输入：[0,0,null,0,null,0,null,null,0]
输出：2
解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。

```

### 算法知识点
1. 本题，最先想到的就是`最小顶点覆盖问题`，并且正好树也是`二分图`的一种。
但最后发现，貌似题解并不涉及此问题。（不懂-，-）。在此，也就复习一下集合论与图论中的一些知识。
    - 什么是[二分图](https://baike.baidu.com/item/%E4%BA%8C%E5%88%86%E5%9B%BE/9089095?fr=aladdin), 以及[二分图的判定方法](https://baike.baidu.com/item/%E4%BA%8C%E5%88%86%E5%9B%BE/9089095?fr=aladdin)
    - 什么是[匹配，最大匹配，完全匹配](https://zhuanlan.zhihu.com/p/89972891)
    - 什么是[最小顶点覆盖问题](https://www.cnblogs.com/wsy107316/p/13442715.html)

2. 解决本题最重要的点是，设计出每个树节点的状态，包括* 每个树节点设置共有三种状态
    - 0：代表该节点安装了监视器
    - 1：代表该节点可被监测，但没有安装监视器
    - 2：代表该节点不可观
    然后利用`后序遍历`(深度优先搜索)递归即可解决问题