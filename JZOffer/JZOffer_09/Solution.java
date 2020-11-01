package JZOffer_09;

import java.util.Stack;

class CQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public CQueue() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }
    
    public void appendTail(int value) { // 直接压入第一个栈即可
        s1.push(value);
    }
    
    /**
     * 个人解法:
     * 先将栈1中的元素全部按照后进先出原则压入栈2中,
     * 然后在栈2中pop出栈顶元素,此元素即为要删除的元素,
     * 最后,再将栈2中的元素压回栈1
     * 
     * 时间复杂读: O(N)
     * 空间复杂度: O(N)
     */
    public int deleteHead1() { 
        if(s1.empty()){
            return -1;
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }

        int ans = s2.pop();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return ans;
    }

    /**
     * 官方解答:
     * 由于进入栈2的元素就是按照队列顺序进行删除的,
     * 因此不必在进入栈1
     * 
     * 时间复杂读: O(1)
     * 空间复杂度: O(N)
     */
    public int deleteHead2(){
        int ans;
        if(!s2.empty()){ // s2不空,直接在s2 pop
            ans = s2.pop();
            return ans;
        }else if(!s1.empty()){ // 若s2为空,s1不空,则将s1的全部转移到s2,在进行pop
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            ans = s2.pop();
            return ans;
        }else{ //s1 s2 都为空,直接返回-1
            return -1;
        }
    }
}

public class Solution {
    
}
