package JZOffer_15;

public class Solution {

    // 位运算1
    public int hammingWeight(int n) {
        int mask = 1;
        int sum = 0;
        for(int i = 0 ; i < 32 ; i++){
            if((n & mask) != 0){
                sum ++;
            }
            mask = mask << 1;
        }
        return sum;
    }

    // 位运算2
    public int hammingWeight1(int n) {
        int mask = 1;
        int sum = 0;
        for(int i = 0 ; i < 32 ; i++){
            if((n & mask) != 0){
                sum ++;
            }
            n = n >>> 1;
        }
        return sum;
    }

    // 位运算 : 技巧 n&(n-1)
    public int hammingWeight2(int n){
        int sum = 0;
        while(n != 0){
            n = n & (n-1);
            sum++;
        }
        return sum;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int res = solution.hammingWeight(15);
        System.out.println(res);
    }
}
