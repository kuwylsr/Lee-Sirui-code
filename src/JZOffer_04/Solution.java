package JZOffer_04;

public class Solution {

    // 个人解法:
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row_num = matrix.length;
        if(row_num == 0){
            return false;
        }
        int col_num = matrix[0].length;
        int i = 0;
        int j = col_num - 1;
        // 从矩阵的右上角开始搜索
        // 时间复杂度 O(n + m)
        while (i <= row_num - 1 && j >= 0) {
            if (target < matrix[i][j]) {
                j--;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 20;
        boolean ans = S.findNumberIn2DArray(matrix, target);
        System.out.println(ans);
    }
}
