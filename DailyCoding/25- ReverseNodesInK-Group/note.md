# 25-K个一组翻转链表

## [题目](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)(难度困难)

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

```markdown
示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

 

说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

```

### 算法知识点
1. 在翻转链表时，我们一定要特别注意到的是在改变某个next时，一定要先记录原始的下一个节点，不然下一个节点将会丢失。

### 编程知识点
1. 