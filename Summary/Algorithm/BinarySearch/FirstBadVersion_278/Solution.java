package Algorithm.BinarySearch.FirstBadVersion_278;

public class Solution {
    
    // 题目的内置API
    public boolean isBadVersion(int num){
        return true;
    }
    

    // 二分查找法解题
    // 时间复杂度: O(logN)
    // 空间复杂度: O(1)
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while(left < right){
            int mid = left + (right - left)/2; // 重点
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    // 线性扫描 (超出时间限制)
    // 时间复杂度: O(N)
    // 空间复杂度 : O(1)
    public int firstBadVersion2(int n){
        for(int i = 1; i <=n ;i ++){
            if(isBadVersion(i)){
                return i;
            }
        }
        return n;
    }
}
