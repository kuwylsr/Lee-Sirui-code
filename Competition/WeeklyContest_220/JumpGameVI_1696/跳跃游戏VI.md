# 1696-跳跃游戏VI

## [题目](https://leetcode-cn.com/problems/jump-game-vi/)(难度中等)

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。

一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。

你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。

请你返回你能得到的 最大得分 。

~~~markdown
示例 1：

输入：nums = [1,-1,-2,4,-7,3], k = 2
输出：7
解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
示例 2：

输入：nums = [10,-5,-2,4,0,3], k = 3
输出：17
解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
示例 3：

输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
输出：0
~~~

**提示**:
- 1 <= nums.length, k <= 10^5
- -10^4 <= nums[i] <= 10^4

### 算法知识点
1. 动态规划 + 优先队列

- 状态定义: 
f(n) 表示跳跃到第n个位置,所能获得的最大得分.

- 递归方程:
$$
f(n) = max_{max\{0,n-k\} \le j \le n-1}(f(j)) + nums[i]
$$

- 使用优先队列(堆)进行优化
由于我们要最大化f(j),因此我们可以使用优先队列(堆)来维护所有的(f(j),j)的二元组. 这样,(满足要求的)优先队列的堆顶元素就是我们递归方程中想找到的`j`.

### 编程知识点
1. Java 中的队列 与 优先队列 的声明
- 队列
    ~~~Java
    Queue<Type> queue = new LinkedList<Type>();
    ~~~
- 优先队列
    ~~~Java
    PriorityQueue<Type> queue = new PriorityQueue<>();
    ~~~

2. 使用匿名内部类函数重写来进行集合排序(重写集合的Comparator类的compare方法)
    ~~~ Java
    PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        // 当返回值>0时
        // 进行交换(本来是o1在前, o2在后)，即排序(源码实现为两枢轴快速排序)
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });
    ~~~

3. 使用lamdba表达式来进行匿名内部类

    ~~~Java
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[0]-o2[0]);
    ~~~



