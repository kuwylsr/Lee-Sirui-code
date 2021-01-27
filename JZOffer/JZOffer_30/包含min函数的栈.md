# 剑指 Offer 30. 包含min函数的栈

## [题目](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)(难度简单)

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

~~~markdown
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();   --> 返回 0.
minStack.min();   --> 返回 -2.
~~~

**提示：**
- 各函数的调用总次数不超过 20000 次

### 算法知识点
1. 方法一: 辅助栈
用另一个栈进行辅助, 来存储栈中的最小值.
具体地, 当要压入的元素小于等于辅助栈的栈顶元素时, 将其压入辅助栈中; 当要pop的元素等于辅助栈的栈顶元素时, 也将其pop出.

2. 方法二 : 辅助栈
用另一个栈进行辅助, 来存储栈中的最小值.
具体地, 每当原始栈要压入一个元素时, 辅助栈都压入一个栈顶和当前元素中最小的元素.