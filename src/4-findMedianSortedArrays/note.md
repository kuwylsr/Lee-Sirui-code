# 4-寻找两个有序数组中的中位数

## [题目](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)（难度困难）

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。

```markdown
示例1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0

示例2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
```

### 算法知识点
1. 本人采用先将两个有序的向量进行归并，归并为一个大的有序的向量，然后在直接取的中位数，但这样做最多会遍历每个元素一遍，使得时间复杂度的上界为 O(m+n)，不满足题目中时间复杂度上界为 O(log(m + n)) 的要求。

2. 看到log的时间复杂度，就要想到二分法，二叉树等等。

3. 温习[二分查找](https://www.geeksforgeeks.org/binary-search/)
```C++
// A recursive binary search function. It returns 
// location of x in given array arr[l..r] is present, 
// otherwise -1 
int binarySearch(int arr[], int l, int r, int x) 
{ 
    if (r >= l) { 
        int mid = l + (r - l) / 2; 
  
        // If the element is present at the middle 
        // itself 
        if (arr[mid] == x) 
            return mid; 
  
        // If element is smaller than mid, then 
        // it can only be present in left subarray 
        if (arr[mid] > x) 
            return binarySearch(arr, l, mid - 1, x); 
  
        // Else the element can only be present 
        // in right subarray 
        return binarySearch(arr, mid + 1, r, x); 
    } 
  
    // We reach here when element is not 
    // present in array 
    return -1; 
} 
```
还有二分查找的[改进版本](https://www.jianshu.com/p/cddfbdbc53c7)。

4. [参考答案](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/)中的解法采用递归法，其解题思路如下：
	(1) 首先，明确了统计中，中位数的作用：
	```markdown
	中位数：将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
	```
	(2) 根据中位数的含义，提出了寻找中位数的目标条件：
	- len(left_part) = len(right_part)
	- max(left_part) $\le$ min(right_part)
	
	如果满足上述条件，则寻找的中位数为：
	$$ median = \frac{max(left{\_}part) + min(right{\_}part)}{2} $$
	（注意这是两个向量总长度为偶数的情况;为奇数的情况见下面）
	其中:
	**left_part**: 将A向量按位置i分割所得到的左半部分(A[0],A[1],...,A[i-1])以及将B向按位置j分割所得到的左半部分(B[0],B[1],...,B[j-1])
	**rigth_part**: 将A向量按位置i分割所得到的左半部分(A[i],A[i+1],...,A[m-1])以及将B向按位置j分割所得到的左半部分(B[j],B[j+1],...,B[n-1])
	(3) 进一步将目标条件转化为数学表达式：
	- i + j = m - i + n - j (或 m - i + n - j + 1),如果 n $\ge$ m , 只需要 i = 0 ~ m , $j = \frac{m+n+1}{2} - i$
	- 在这里采用 i + j = m - i + n - j + 1 ,使得当两个向量的总长度为奇数的时候，中位数为：
	$$ median = max(left{\_}part) $$
	若采用 i + j = m - i + n - j ,使得当两个向量的总长度为奇数的时候，中位数为：
	$$ median = min(right{\_}part) $$
	- $B[j-1] \le A[i]$ 以及 $A[i-1] \le B[j]$

	加入临界条件，可以得到最终的目标条件：
	- (j = 0 or i = m or $B[j-1] \le A[i]$) 并且
	(i = 0 or j = n or $A[i-1] \le B[j]$),其中 $j = \frac{m+n+1}{2} - i$

	(4)在循环搜索中，我们要处理的三种情况：
	- (j = 0 or i = m or $B[j-1] \le A[i]$) 并且
	(i = 0 or j = n or $A[i-1] \le B[j]$), 这意味着i时完美的，我们可以停止搜索。
	- j > 0 and i < m and B[j-1] > A[i] 这意味着i太小，我们必须增大它。
	- i > 0 and j < n and A[i-1] > B[j] 这意味着i太大，我们必须增大它。

	(5)对于循环搜索中i的搜索，可以采用二分搜索的方式进行来降低时间复杂度。
	(6) **复杂度分析**
    - 时间复杂度：O(log(min(m,n)))
	首先，查找的区间时[0,m]。
	搜索的方式采用二分查找的思想，搜索区间长度在每次循环之后都会减少为原来的一半。
	因此，我们只需要执行 log(m) 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为 O(log(m))。
	由于 $m \le n$ ，所以整体算法的时间复杂度为O(log(min(m,n)))
	- 空间复杂度
	我们只需要恒定的内存来存储9个局部变量，所以空间复杂度为O(1)。



### 编程知识点
1. C++中向量[vector](https://blog.csdn.net/laobai1015/article/details/51218871)的使用。
