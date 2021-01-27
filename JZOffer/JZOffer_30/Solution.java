package JZOffer_30;

import java.util.Stack;

public class Solution {
    
    // 方法一:
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> stack_min;
        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<Integer>();
            this.stack_min = new Stack<Integer>();
        }
        
        public void push(int x) {
            stack.push(x);
            if(stack_min.empty() || x <= stack_min.peek()){
                System.out.println(x);
                stack_min.push(x);
            }
        }
        
        public void pop() {
            if(stack.peek().equals(stack_min.peek())){ //因为栈中的元素为Integer包装类型, == 比较的是地址
                stack_min.pop();
            }
            stack.pop();
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int min() {
            return stack_min.peek();
        }
    }


    // 方法二:
    class MinStack2 {

        Stack<Integer> stack;
        Stack<Integer> stack_min;
        /** initialize your data structure here. */
        public MinStack2() {
            this.stack = new Stack<Integer>();
            this.stack_min = new Stack<Integer>();
            stack_min.push(Integer.MAX_VALUE);
        }
        
        public void push(int x) {
            stack.push(x);
            stack_min.push(Math.min(stack_min.peek(), x));
        }
        
        public void pop() {
            stack.pop();
            stack_min.pop();
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int min() {
            return stack_min.peek();
        }
    }
    
}
