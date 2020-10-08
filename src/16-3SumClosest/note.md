# 16-最接近的三数之和

## [题目](https://leetcode-cn.com/problems/3sum-closest/)(难度中等)

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

```markdown
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
```

### **算法知识点**
1. 本人一开始向利用最大堆解题，来求得与目标target最接近的三个值（差值最小），但最后发现，与target差值最小的三个值的和 不一定是 与target值差距最小的。我们要找的是三个数的和与target差距最小，所以此方案失败。

2. 

### **编程知识点**
1. 数据结构-[堆](https://blog.csdn.net/qq_41357771/article/details/79416127)
在这道题目中，由于逻辑问题，误以为可以使用堆来解决问题，但由于也比较缺乏对堆的理解，在此进行复习。
    - [最大堆和最小堆](https://blog.csdn.net/nisxiya/article/details/45725857)的实现
    - [代码参考](https://www.cnblogs.com/geooeg/p/7811833.html)
    - [维护堆的性质](https://blog.csdn.net/yangtzhou/article/details/84780574)

2. C++的关键字--[friend](https://www.cnblogs.com/MakeView660/p/6913263.html)

3. C++的关键字--[operator](http://blog.sina.com.cn/s/blog_4b3c1f950100kker.html)

4. C++的关键字--[const](https://www.runoob.com/w3cnote/cpp-const-keyword.html)

5. C++中 指针符号 `*` 和 引用符号 `&`
指针：指向的是变量的地址
引用：是变量的别名
`*`: 定义指针 或者 解引用
`&`: 取地址符 或者 引用(取别名)
[*和&的区别](https://blog.csdn.net/weixin_42878758/article/details/82865314?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task)

6. C++ 中类对象和类指针的区别
[区别](https://blog.csdn.net/keneyr/article/details/89364275) 
[.和->的用法](https://blog.csdn.net/u013719339/article/details/80611509)

    一个例子：
    ```C++
    class Node {
    public:
        int value;
        int idx;
        Node(int v, int i){ 
            value = v;
            idx = i;
        }
    };

    // 函数一：参数接受指针（即地址）
    int test_function1(Node *n,int v){
        n->value = v;
    }
    // 函数二：参数接受引用（即别名）
    int test_function2(Node& n,int v){
        n.value = v;
    }
    int main(){

        Node *n1 = new Node(100,0); //定义一个指针指向对象（即类指针）
        Node n2(102,1); //定义一个类对象（即类对象）
        cout << "n1_value = " << n1->value << endl;
        cout << "n2_value = " << n2.value << endl;

        test_function1(n1,32); //传入指针类型（地址）n1
        test_function2(n2,43); //传入类对象 n2
        cout << "n1_value = " << n1->value << endl;
        cout << "n2_value = " << n2.value << endl;

        test_function1(&n2,30); //传入类对象n2的地址（&:取地址符）
        test_function2(*n1,42); //传入指针n1指向的对象（*:解引用）
        cout << "n1_value = " << n1->value << endl;
        cout << "n2_value = " << n2.value << endl;
        return 0;
    }
    ```
    结果：
    ```markdown
    n1_value = 100
    n2_value = 102
    n1_value = 32
    n2_value = 43
    n1_value = 42
    n2_value = 30
    ```