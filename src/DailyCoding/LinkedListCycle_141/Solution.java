package DailyCoding.LinkedListCycle_141;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
    @Override
    public int hashCode(){
        return this.hashCode();
    }

    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject){
            return true;
        }
        return false;
    }
}

public class Solution {

    // 个人解法：通过 hashset 进行存储
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<ListNode>();
        ListNode p = head;
        if(p == null) return false;
        while(p != null){
            if(s.contains(p)){
                return true;
            }
            s.add(p);
            p = p.next;
        }
        return false;
    }

    // 题解答案： 快慢指针 (类似龟兔赛跑算法) (Floyd判圈算法)
    public boolean hasCycle2(ListNode head){
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != null && fast != null){
            if(slow.equals(fast)){
                return true;
            }
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
