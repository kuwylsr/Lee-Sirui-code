# 21-合并两个有序链表

## [题目](https://leetcode-cn.com/problems/merge-two-sorted-lists/)(难度简单)

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

```markdown
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

### 算法知识点
1. 递归法
递归的定义：
$$
\begin{cases}
list1[0] + merge(list1[1:],list2) & \text{list1[0] < list2[0]}\\
list2[0] + merge(list1,list2[1:])& \text{otherwise}\\
\end{cases}
$$

2. 迭代(类似于归并排序)

### 编程知识点
1. 