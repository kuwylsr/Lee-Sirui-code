# 213-打家劫舍 II

## [题目](https://leetcode-cn.com/problems/house-robber-ii/)(难度中等)

你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

~~~markdown
示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [0]
输出：0
~~~

提示：

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 1000

### 算法知识点
1. 动态规划 (打家劫舍系列)
本题,与 198-打家劫舍 唯一的不同点在于,他是一个环,要求第一间房屋不能与最后一间房屋同时被偷窃, 因此我们只需要将最后一间房屋去掉做一次动态规划, 再将第一间房屋去掉做一次动态规划即可.

每次动态规划见 198 题

### 编程知识点
1. java的 Arrays 工具类的用法

- fill() 方法 : 填充数组
    ~~~java
    int[] array=new int[5]; 
    Arrays.fill(array,5);
    System.out.println("填充数组：Arrays.fill(array, 5)：");
    output(array);
    //结果是：5 5 5 5 5
    //分析：给所有值赋值5
    ~~~
    

    ~~~java
    int[] array=new int[5]; 
    Arrays.fill(array, 2, 4, 8);
    output(array);
    //结果是：5 5 8 8 5
    //分析：给第2位（0开始）到第4位（不包括）赋值8
    ~~~

- sort() 方法: 数组元素排序
    ~~~java
    int[] intTest={15,78,32,5,29,22,17,34};
    Arrays.sort(intTest);
    output(intTest);
    //结果是：5 15 17 22 29 32 34 78
    //分析：给所有数按升序排序
    ~~~

    ~~~java
    int[] intTest={15,78,32,5,29,22,17,34};
    Arrays.sort(intTest,2,6);
    output(intTest);
    //结果是：15 78 5 22 29 32 17 34
    //分析：给第2位（0开始）到第6位（不包括）排序
    ~~~   

- equals() 方法 : 比较数组元素是否相等
    ~~~java
    int []arr1 = {1,2,3};
    int []arr2 = {1,2,3};
    System.out.println(Arrays.equals(arr1,arr2));
    //结果是：true
    //分析：如果是arr1.equals(arr2),则返回false，因为equals比较的是两个对象的地址，不是里面的数，
    //而Arrays.equals重写了equals，所以，这里能比较元素是否相等。
    // 注意：如果两个数组元素值一样，但是两个数组对应位置元素不同，Arrays.equals返回结果是false。
    ~~~   

    ~~~java
    int[] intTesta={15,78,32,5,29,22,17,34};
    int[] intTestb={78,15,32,5,29,22,17,34};
    System.out.println(Arrays.equals(intTesta, intTestb));
    //结果是：false
    //分析：两个数组对应位置的元素不相等。
    ~~~   

- binarySearch() 方法 : 二分查找法找指定元素的索引值(下标)
注意：数组一定是排好序的，否则会出错。找到元素，只会返回最后一个位置

    ~~~java
    int[] testA={5,7,12,45,57,66,81};
    System.out.println(Arrays.binarySearch(testA, 12));
    //结果是：2
    //分析：能找到该元素，返回下标为2（0开始）
    ~~~ 

    ~~~java
    int[] testA={5,7,12,45,57,66,81};
    System.out.println(Arrays.binarySearch(testA, 9));
    //结果是：-3
    //分析：找不到元素，返回-x，从-1开始数，如题，返回-3
    ~~~ 

    ~~~java
    int[] testA={5,7,12,45,57,66,81};
    System.out.println(Arrays.binarySearch(testA, 0,3,12));
    //结果是：2
    //分析：从0到3位（不包括）找12，找到了，在第2位，返回2
    ~~~

    ~~~java
    int[] testA={5,7,12,45,57,66,81};
    System.out.println(Arrays.binarySearch(testA, 0,2,12));
    //结果是：-3
    //分析：从0到2位（不包括）找12，找不到，从-1开始数，返回-3
    ~~~     

- copyOf() and copyOfRange() 方法 : 截取数组

    ~~~java
    int[] array={5, 5, 8, 8, 5};
    int[] copyarray = Arrays.copyOf(array, 4);
    output(copyarray);
    //结果是：5 5 8 8
    //分析：截取array数组的4个元素赋值给数组copyarray
    ~~~   

    ~~~java
    int[] array={5, 5, 8, 8, 5};
    int[] copyOfRange = Arrays.copyOfRange(array, 1, 4);
    output(copyOfRange);
    //结果是：5 8 8
    //分析：从第1位（0开始）截取到第4位（不包括）
    ~~~ 

- toString() 方法 : 打印数组元素
    ~~~java
    String[] stringTest = {"hello","how","are","you","!"};
    System.out.println(Arrays.toString(stringTest));
    //结果是：[hello, how, are, you, !]
    ~~~ 

- asList() 方法 : 数组转换List
    ~~~java
    String[] stringTest = {"hello","how","are","you","!"};
    List<String> list = Arrays.asList(stringTest);
    for(String te : list){
        System.out.print(te+" ");
    }
    // 结果 :hello how are you !
    ~~~ 

[参考网址](https://blog.csdn.net/wilson_m/article/details/80168692)