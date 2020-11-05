package IntersectionOfTwoArrays_349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.*;


public class Solution {

    // 个人解法: 利用哈希表求解
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            return nums2;
        }else if(nums2.length == 0){
            return nums1;
        }

        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        for(int num : nums1){ //对nums1进行去重
            s1.add(num);
        }
        for(int num : nums2){ //对nums2进行去重
            s2.add(num);
        }

        Set<Integer> ansSet = new HashSet<Integer>();
        Iterator<Integer> it = s2.iterator();
        while(it.hasNext()){ // 将两个集合合并, 得到重复的元素放入另一个哈希表中
            int num = it.next();
            if(s1.add(num) == false){
                ansSet.add(num);
            }
        }

        int[] ans = new int[ansSet.size()]; // 将哈希表ansSet中的元素放入数组
        Iterator<Integer> it2 = ansSet.iterator();
        int i =0;
        while(it2.hasNext()){
            ans[i] = it2.next();
            i++;
        }
        return ans;
    }
}
