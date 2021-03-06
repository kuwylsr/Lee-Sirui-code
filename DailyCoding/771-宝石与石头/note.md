# 771-宝石与石头

给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

~~~markdown
示例 1:

输入: J = "aA", S = "aAAbbbb"
输出: 3
示例 2:

输入: J = "z", S = "ZZ"
输出: 0
~~~

**注意**：
- S 和 J 最多含有50个字母。
- J 中的字符不重复。

### 算法知识点
1. 哈希集合存储字符串 $J$ 中的宝石，则可以降低判断的时间复杂度。

2. 时空复杂度
- 时间复杂度：$O(m+n)$ ，其中 $m$ 是字符串 $J$ 的长度，$n$ 是字符串 $S$ 的长度。遍历字符串 $J$ 将其中的字符存储到哈希集合中，时间复杂度是 $O(m)$ ，然后遍历字符串 $S$ ，对于 $S$ 中的每个字符在 $O(1)$ 的时间内判断当前字符是否是宝石，时间复杂度是 $O(n)$ ，因此总时间复杂度是 $O(m+n)$ 。

- 空间复杂度：$O(m)$ ，其中 $m$ 是字符串 $J$ 的长度。使用哈希集合存储字符串 $J$ 中的字符。
