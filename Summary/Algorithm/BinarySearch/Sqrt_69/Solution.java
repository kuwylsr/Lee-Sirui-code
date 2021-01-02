package Algorithm.BinarySearch.Sqrt_69;

public class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        int tmp_min = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long tmp = (long)mid * mid;
            if(tmp == x){
                return mid;
            }else if(tmp > x){
                right = mid - 1;
            }else if(tmp < x){
                left = mid + 1;
                tmp_min = mid;
            }
        }
        return tmp_min;
    }
}
