package JZOffer_06;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    // 个人解法: 将链表指针反过来,再遍历
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int[] reversePrint1(ListNode head) {
        ListNode p = head;
        ListNode hair = new ListNode(-1);
        hair.next = head;

        int len = 0;
        ListNode ppr = hair; // 前置指针
        ListNode pps; // 后置指针
        while(p != null){
            len ++;
            pps = p.next; //记录后继节点
            p.next = ppr;

            ppr = p; //记录前驱节点
            p = pps;
        }
        p = ppr;
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = p.val;
            p = p.next;
        }
        return ans;
    }

    // 官方题解: 利用栈
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int[] reversePrint2(ListNode head){
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        int len = 0;
        while(p != null){
            s.push(p.val);
            p = p.next;
            len++;
        }
        int[] ans = new int[len];
        int i = 0;
        while(!s.empty()){
            ans[i++] = s.pop();
        }
        return ans;
    }
   
    // 评论区题解: 得到数组长度,倒着填数组
    public int[] reversePrint3(ListNode head){
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len ++;
            p = p.next;
        }
        p = head;
        int[] ans = new int[len];
        for(int i = len - 1;i >= 0 ;i--){ // 倒序填入数组
            ans[i] = p.val;
            p = p.next;
        }
        return ans;
    }
}