package Algorithm.BinarySearch.FindSmallestLetterGreaterThanTarget_744;

public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int target_num = target - 'a';
        int left = 0;
        int right = len-1;
        int tmp_min = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(letters[mid] - 'a' <= target_num){
                left = mid + 1;
            }else{
                right = mid - 1;
                tmp_min = mid; //比中间值大的需要被记录
            }
        }
        return letters[tmp_min];
    }
}
