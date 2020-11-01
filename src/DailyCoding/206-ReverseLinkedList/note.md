# 206-翻转列表

## [题目](https://leetcode-cn.com/problems/reverse-linked-list/)(难度简单)

反转一个单链表。

```markdown
示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

### 算法知识点
1. 在做链表翻转时，我们要利用pre来记录p的前一个节点，用nex记录p的后一个节点，nex的记录必须在p改变next指针之前，否则nex节点将会丢失。