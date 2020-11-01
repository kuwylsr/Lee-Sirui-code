# 617-合并二叉树

## [题目](https://leetcode-cn.com/problems/merge-two-binary-trees/)(难度简单)

给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

```markdown
示例 1:

输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

```
**注意：** 合并必须从两个树的根节点开始。

### 算法知识点
1. 一开始考虑出现差错，认为不能递归地同时遍历两颗树，但后来发现算法有两个参数，所以可以用递归的方法求解。

2. 非递归的方法，利用了 `栈` 的数据结构，一次压栈分为压入两颗树的元素，进行处理。