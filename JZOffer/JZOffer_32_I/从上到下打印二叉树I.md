# 剑指 Offer 32 - I. 从上到下打印二叉树

## [题目](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)(难度中等)

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 
~~~markdown
例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]
~~~ 

**提示：**
- 节点总数 <= 1000

### 算法知识点
1. BFS

### 编程知识点
1. Java队列(Queue)

- 声明
    ~~~Java
    Queue<Integer> queue = new LinkedList<Integer>();
    ~~~

- 方法
    ~~~java
    offer() //添加元素
    poll() //弹出并返回队首
    peek() //返回队首
    isEmpty() //是否为空
    size() //获取大小
    ~~~

2. 数组 和 ArrayList 的相互转换

- Array 转 ArrayList
    Arrays.asList() 方法
    ~~~Java
    List<String> list = Arrays.asList(array);
    ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));

    // 用此方法得到的List的长度是不可改变的
    // 该方法适用于对象型数据的数组(String, Integer...)
    // 该方法将数组与List列表链接起来：当更新其一个时，另一个自动更新
    // 不支持add()、remove()、clear()等方法
    ~~~

- ArrayList 转 Array
    list.toArray()方法
    ~~~Java 
    String[] array = (String[])list.toArray(new String[size])

    // 该方法适用于对象型数据的数组(String, Integer...)
    ~~~