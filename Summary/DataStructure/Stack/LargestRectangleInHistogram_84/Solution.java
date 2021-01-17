package DataStructure.Stack.LargestRectangleInHistogram_84;

import java.util.Stack;

public class Solution {

    // 暴力解法 : 枚举所有矩形的高度 (超时)
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        int max_area = 0;
        int l,r;

        for(int i = 0 ; i < len ; i++){
            l = i-1;
            r = i+1;
            int height = heights[i];
            // 向左扩散, 确定最大左边界
            while(l >= 0 && heights[l] >= height){
                l--;
            }

            // 向右扩散, 确定最大右边界
            while(r <= len-1 && heights[r] >= height){
                r++;
            }
            max_area = Math.max(max_area, ((r-1)-(l+1)+1) * height);
        }
        return max_area;
    }

    // 单调栈
    public int largestRectangleArea2(int[] heights) {
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
