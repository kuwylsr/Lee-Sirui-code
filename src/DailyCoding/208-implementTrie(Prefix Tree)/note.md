---
title: note title
tags: tag1, tag2, tag3
notebook: 我的第一个笔记本
---

# 实现 Trie（前缀树）

## [题目](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)(难度中等)

实现一个 Trie (前缀树)，包含 `insert`, `search`, 和 `startsWith` 这三个操作。

```C++
示例1：
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
```
说明:

- 你可以假设所有的输入都是由小写字母 a-z 构成的。
- 保证所有输入均为非空字符串。

### **算法知识点**
1. 了解数据结构--[树](https://blog.csdn.net/qq_30611601/article/details/80652731)
树的本质就是一个多叉的链表，每个结点有零个或多个子结点；没有父结点的结点称为根结点；每一个非根结点有且只有一个父结点；除了根结点外，每个子结点可以分为多个不相交的子树。


