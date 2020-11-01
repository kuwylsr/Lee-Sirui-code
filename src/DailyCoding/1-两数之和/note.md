# 第1题-两数之和

## [题目](https://leetcode-cn.com/problems/two-sum/)(难度简单)
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。   
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。   
  
```markdow
示例:  
给定 nums = [2, 7, 11, 15], target = 9  
因为 nums[0] + nums[1] = 2 + 7 = 9  
所以返回 [0, 1]
```


### **算法知识点**
1. 这里是[题目的三种解法](https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/)
2. 参考答案中的第三种解法比较巧妙，因为两个数之和，在遍历的时候会出现两遍，所以就可以一边向map中插入元素一边进行查找，这样产生的逻辑就是每个元素只能观察它之前的元素是否与它的和满足要求，同样可以求得并且不漏掉答案。

### **编程知识点**
1. 了解[哈希表](https://blog.csdn.net/u011109881/article/details/80379505)
2. 此题使用hashmap来提高查找key值列表中某一元素的速度，（这里是[hash_map的数据结构解析](https://blog.csdn.net/qq_41345773/article/details/92066554)，这里是[C++hashmap的使用](https://stackoverflow.com/questions/3578083/what-is-the-best-way-to-use-a-hashmap-in-c)（注意区分hashmap和map查找元素的效率的不同））