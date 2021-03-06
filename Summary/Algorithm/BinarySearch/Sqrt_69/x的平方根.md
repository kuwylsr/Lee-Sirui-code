# 69-x的平方根

## [题目](https://leetcode-cn.com/problems/sqrtx/)(难度简单)

实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

~~~markdown
示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
~~~

### 算法知识点
1. 二分查找
此题中, 我们要计算一个数的开平方(的整数部分), 也就是我们要找一个整数, 它的平方从左侧最靠近目标值. (而`744-寻找比目标字母大的最小字母` 找的是从右侧最靠近目标值的字母). 即当中间值小于目标值时,我们需要进行记录.

2. 需要注意溢出的问题
当我们计算一个数的平方的时候, 两个int类型的乘积可能超出int类型的取值范围, 因此我们应该进行类型转换,使用long类型进行存储.