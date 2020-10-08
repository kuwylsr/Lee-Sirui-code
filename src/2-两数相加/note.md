# 2-两数相加

## [题目](https://leetcode-cn.com/problems/add-two-numbers/)(难度中等)  
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

```markdown
示例:  
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

### **算法知识点**
1. 本题[答案](https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/)
2. 题目扩展
    ```markdown
    如果链表中的数字不是按逆序存储的呢?
    ```
    可以采用递归或者栈的数据结构来解题。

### **编程知识点**
1. 注意C或者C++列表的遍历方式，一般是通过在另外声明一个指针来指向目 标链表的头节点来进行遍历，在本题中采用以下代码进行遍历：
    ```C++
    ListNode* p = l1;
    ListNode* q = l2;
    ListNode* curr = result;
    ```
2. C++的[结构体](https://www.cnblogs.com/zhengfa-af/p/8144786.html)的用法。
3. 注意在函数后面加冒号":"后面跟的是赋值，在本题中为结构体成员变量赋值：
    ```C++
    ListNode(int x) : val(x), next(NULL){}
    ```