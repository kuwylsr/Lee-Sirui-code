### 回文数

## [题目](https://leetcode-cn.com/problems/palindrome-number/)

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

```markdown
示例1：
输入: 121
输出: true

示例2：
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例3：
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
```
### **算法知识点**
1. 取出一个整数的末尾 `int temp = x % 10; // 取出个位`
2. 去除一个整数的末尾 `x /= 10; // 去除末尾`
3. 对一个数的算法，就一定要注意目标数的数据类型以及溢出问题。
4. 参考答案中的核心是 **我们将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字。**
- **时间复杂度** ：$O(log_{10}(n))$ ，对于每次迭代，我们会将输入除以10，因此时间复杂度为 $O(log_{10}(n))$
- **空间复杂度** ：$O(1)$

### **编程知识点**
1. 

