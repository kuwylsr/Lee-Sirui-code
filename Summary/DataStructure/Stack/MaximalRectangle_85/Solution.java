package DataStructure.Stack.MaximalRectangle_85;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int M = matrix.length;
        if(M == 0){
            return 0;
        }
        int N = matrix[0].length;
        
        int[][] AllHeights = new int[M][N]; //以每一行最为基础行的 Heights数组.
        for(int j = 0 ; j< N ;j++){ //初始化第0行
            AllHeights[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for(int i = 1 ; i < M ;i++){
            for(int j = 0 ; j < N ;j++){
                AllHeights[i][j] = matrix[i][j] == '1' ? AllHeights[i-1][j] +1 : 0;
            }
        }

        int max_area = 0;
        for(int i = 0 ; i < M ;i++){
            max_area = Math.max(max_area, largestRectangleArea(AllHeights[i]));
        }
        return max_area;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        
        stack.add(-1); //压入一个边界元素代表下标-1
        stack.add(0);
        int max_area = 0;
        int i = 1;
        while(!stack.empty()){
            // 首先将当前要加入的高度 与 栈顶高度比较
            int tmp_height = (i == len) ? -1 : heights[i];
            int s_index = stack.peek();
            int s_height = (s_index == -1 || s_index == len) ? -1 : heights[s_index];

            if(s_index == -1 && i == len){
                break;
            }

            if(tmp_height < s_height){ //说明当前栈顶的高度所对应宽度可以确定
                stack.pop(); // 弹出当前栈顶元素
                max_area = Math.max(max_area, s_height * (i - stack.peek() -1));
                continue; //将当前元素继续与弹出后的栈顶比较.
            }else if(tmp_height == s_height){ // 用下标取代之前相同高度的柱子
                stack.pop();
                stack.add(i);
                i++;
            }else{
                stack.add(i);
                i++;
            }
        }
        return max_area;
    }
}
