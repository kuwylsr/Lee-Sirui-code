# 最长公共前缀

## [题目](https://leetcode-cn.com/problems/longest-common-prefix/)(难度简单)

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

```markdown
示例1：
输入: ["flower","flow","flight"]
输出: "fl"

示例2：
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
```
说明：所有输入只包含小写字母 `a-z`

### **算法知识点**
$LCP(S_1,...,S_n)$ 是字符串 $[S_1,...,S_n]$ 的最长公共前缀，1 < k < n

1. 方法一：水平扫描法
原理：$LCP(S_1,...,S_n) = LCP(LCP(LCP(S_1,S_2),S_3),...,S_n)$
即以此计算两个字符串的公共前缀即可。
再利用java string库中的 [indexof()](https://www.runoob.com/java/java-string-indexof.html) 可巧秒解题。通过判断 `strs[i].indexOf(prefix) != 0` 来确定某个字符串是否包含前缀 `prefix`

2. 方法二：按列扫描
原理：外层循环扫描列，内层循环扫描行；即每次扫描所有字符串的相同位置的字符。

3. 方法三：分治
原理：$LCP(S_1,...,S_n) = LCP(LCP(S_1,...,S_k),LCP(S_{k+1},...,S_n))$

### **编程知识点**
1. 
