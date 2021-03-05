# 863-二叉树中所有距离为K的结点

## [题目](https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/)(难度中等)

给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。

返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。


~~~
示例 1：

输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
输出：[7,4,1]
解释：
所求结点为与目标结点（值为 5）距离为 2 的结点，
值分别为 7，4，以及 1

~~~

![image](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/06/28/sketch0.png)

~~~
注意，输入的 "root" 和 "target" 实际上是树上的结点。
上面的输入仅仅是对这些对象进行了序列化描述。
~~~

**提醒:**
- 给定的树是非空的。
- 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
- 目标结点 target 是树上的结点。
- 0 <= K <= 1000.

### 算法知识点
1. DFS + BFS

    首先, 利用dfs深度优先搜索, 遍历树的每个结点, 为每个节点创建一个指向其父亲节点的指针.

    然后, 利用bfs层序遍历, 从target节点开始, 依次向外扩展(左,右,父), 知道扩展到第K层,第K层的节点就是我们要找的目标节点.

### 编程知识点
1. map

- 方法

    ~~~java
    get() //获取指定键(key)所对应的值(value)
    getOrDefault();
    put() //将指定的键与值对应起来，并添加到集合中,方法返回值为键所对应的值
    remove() //根据指定的键(key)删除元素，返回被删除元素的值(value)。
    ~~~

- 遍历

    ~~~java
    //创建Map对象
    Map<String, String> map = new HashMap<String,String>();

    Set<String> set1 = map.keySet();
    Iterator<String> it1 = set1.iterator();
    while(it1.hasNext()){
        String key = it1.next();
    }

    Set<Entry<String,String>> set2 = map.entrySet();
    Iterator<Entry<String,String>> it2 = set2.iterator();
    while(it2.hasNext()){
        Entry<String,String> entry = it2.next();
        String key = entry.getKey();
        String value = entry.getValue();
    }

    //foreach
    for(Entry<String,String> entry : map.entrySet()){
        //...
    }
    ~~~