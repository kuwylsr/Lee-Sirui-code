# 剑指 Offer 32 - III. 从上到下打印二叉树 III

## [题目](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)(难度中等)

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 
~~~markdown
例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]
~~~

**提示：**
- 节点总数 <= 1000

### 算法知识点
1. 层序遍历 + 双端队列
我们只需要按照正常的层序进行遍历, 然后在输出每一层的结果值的时候, 使用一个 `双端队列` 分奇偶层, 分别从队尾和队首添加元素, 实现每一层的正序和逆序即可.
需要注意的是, 由于此题的返回值类型为 `List<List<Integer>>`, 因此我们在定义双端队列时的引用应该为 `LinkedList<Integer>` 类型, 而不能是 `Deque<Integer>` 类型. (虽然两者都能实现双端队列)

### 编程知识点
1. Java 双端队列

- 声明
    ~~~Java
    Deque<Integer> deque = new LinkedList<Integer>();
    ~~~

- 方法
    ~~~Java
    offerFirst()
    offerLast()
    pollFirst()
    pollLast()
    peekFirst()
    peekLast()
    ~~~

    [web](https://blog.csdn.net/devnn/article/details/82716447)