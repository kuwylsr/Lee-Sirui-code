package SquaresOfASortedArray_977;

public class Solution {

    // 个人解法:
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        int p1 = -1;
        int p2 = len;
        for (int i = 0; i < len; i++) {
            if (A[i] >= 0) {
                p2 = i;
                break;
            }
        }
        p1 = (p2 == -1) ? (len - 1) : (p2 - 1); // 确定p1 和 p2的位置,分界线

        // 归并排序 (之前写复杂了,都可以归结为一种情况)
        int index = 0;
        while (p1 >= 0 || p2 <= len - 1) {
            if(p1 < 0){
                ans[index++] = A[p2] * A[p2];
                p2++;
            }else if(p2 > len - 1){
                ans[index++] = A[p1] * A[p1];
                p1--;
            }else if (Math.abs(A[p1]) < Math.abs(A[p2])) {
                ans[index++] = A[p1] * A[p1];
                p1--;
            } else {
                ans[index++] = A[p2] * A[p2];
                p2++;
            }
        }
        return ans;
    }
    

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] A = { -4, -1, 0, 3, 10 };
        int[] ans = S.sortedSquares(A);
        for (int i : ans) {
            System.out.print(i + ",");
        }
    }
}
