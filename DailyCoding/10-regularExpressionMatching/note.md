### 正则表达式匹配

## [题目](https://leetcode-cn.com/problems/regular-expression-matching/)(难度困难)

给你一个字符串 `s` 和一个字符规律 `p` ，请你来实现一个支持 `'.'` 和 `'*'` 的正则表达式匹配。
```markdown
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
```
所谓匹配，是要涵盖**整个**字符串 `s` 的，而不是部分字符串。
**说明：**
    - `s` 可能为空，且只包含从 `a-z` 的小写字母。
    - `p` 可能为空，且只包含从 `a-z` 的小写字母，以及字符 `.` 和 `*`。

```markdown
示例1：
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

示例2：
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

示例3：
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

示例4：
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

示例5：
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
```

### **算法知识点**
1. 方法一：使用的是[回溯法](https://blog.csdn.net/sinat_27908213/article/details/80599460)，此问题之所以能使用回溯法，是因为 '*' 的匹配有多种选择，可以选择匹配0个或者多个前一个字符，这就导致了不确定性，因为我们也无法知道选择哪种匹配方式可以匹配成功，所以当匹配失败的时候，就需要“回溯”。
![图解](https://pic.leetcode-cn.com/7c933f57e4f71c61a9bb4eb5d80c6f54373a3787b2c17255e3cefba4ecd06ed6-file_1560139042317)
[参考讲解](https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/)

2. 方法二：[动态规划(Dynamic Programming)](https://blog.csdn.net/zw6161080123/article/details/80639932)
能采用动态规划求解问题的一般要具有的3个性质：
    - **最优化原理**
    - **无后效性**
    - **有重叠子问题**
动态规划的4个阶段：
    - **划分阶段**
    - **确定状态和状态变量**
    - **确定决策并写出状态转移方程**
    - **寻找边界条件**

    (1) [自顶向下的动态规划](https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/)
简单来说，其与前面使用的回溯法最大的区别在于，使用了“备忘录”递归的方法来降低复杂度（因为问题就有重叠子问题），可以发现此解法无非就是回溯法“翻译”了一遍，加上了个memo作为备忘录，仅此而已。
在此放一个网友的评论，正确性及准确性有待商讨：
![评论](/home/kuwy/vscode-workspace/10-regularExpressionMatching/images/sendpix0.jpg)

    (2) [自底向上的动态规划](https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/)
自底向上的动态规划，很直接的想法就是，`dp[i][j]` 表示 `s` 的前i个是否能被 `p` 的前j个匹配。
**状态** ： dp[i][j]
**状态转移方程** ：
$$dp[i][j]=
\begin{cases}
dp[i-1][j-1] & \text{s[i] == p[i] or p[j] == '.'}\\
dp[i][j-2]& \text{p[j] == '*' and s[i] != p[j-1]}\\
\text{dp[i][j-2] or dp[i-1][j]}& \text{p[j] == '*' and s[i] == p[j-1]}\\
\end{cases}$$ (状态转移方程见注释)

3. 自顶向下和自底向上的区别与联系
[参考网址1](https://blog.csdn.net/wenniuwuren/article/details/94603280)
[参考网址2](https://blog.csdn.net/Handsome2013/article/details/90051333)

### **编程知识点**
1. 用vector创建固定大小的多维数组的[方法](https://blog.csdn.net/liuweiyuxiang/article/details/88692708)
```C++
//一步到尾
vector<vector<int>> v1(4,vector<int>(5))

//分步完成
vector<vector<int>> v1;
vector<int> temp(4)
v1.resize(5,temp)
```

