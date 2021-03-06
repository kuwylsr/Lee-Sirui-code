# 19-删除链表的倒数第N个节点

## [题目](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)(难度中等)

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

```markdown
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```

**说明**:给定的 n 保证是有效的。

### 算法知识点
1. 个人解法（一遍扫描 + hashmap）
通过一遍扫描，并且利用hashmap来记录每个节点（ListNode）所对应的下标，以此就能得到倒数第n个节点。
**注意**： 需要注意的是在map中存储的应该是 `<int,ListNode*>` 即为下标和下标所对应的节点的指针（地址），而不能直接存储 `ListNode` 对象，因为存储的map中时，会对原对象进行拷贝，因此在取出来之后，并不是目标节点（是被拷贝过的）。

2. 参考答案解法（**双指针**（一遍扫描））
此方法不需要额外的空间开销来记录每个下标及其对应的节点。通过两个指针，通过初始化两个指针（其中一个指针指向“头节点”，另一个指针与前一个指针保持 `n` 的距离，这样当一个指针到达链表末尾时，另一个指针就能轻松的确定 `倒数第n个节点` 的位置）。
**注意**：首先我们将添加一个哑结点作为辅助，该结点位于列表头部。哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。


### 编程知识点
1. C++的map
当向map中插入pair时，内部是通过拷贝实现的，并不是将原有的本身数据存到map中。