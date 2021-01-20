package PowerOfTwo_231;

public class Solution {
    
    // 个人解法
    public boolean isPowerOfTwo(int n) { 
        if(n < 0){
            return false;
        }       
        int num = 0;
        int mask = 1;
        while(n > 0){
            if((n & mask) == 1){
                num ++;
            }
            n = n >>> 1;
        }
        return num == 1 ? true : false;
    }

    // 其他巧妙解法
    public boolean isPowerOfTwo2(int n){
        return n > 0 && ((n & (n-1)) == 0) ;
    }
}
