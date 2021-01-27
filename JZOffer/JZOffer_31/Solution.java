package JZOffer_31;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i = 0 ; i < pushed.length; i++){
            stack.push(pushed[i]);

            while(!stack.empty() && stack.peek() == popped[index]){ //判断是否进行弹出操作
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
