package JZOffer_22;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // 方法1 : 
    public ListNode getKthFromEnd2(ListNode head, int k) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode p = head;
        while(p != null){
            list.add(p);
            p = p.next;
        }
        return list.get(list.size()-k);
    }

    // 方法2 : 快慢指针
    public ListNode getKthFromEnd(ListNode head, int k){
        ListNode slow = head; //初始化慢指针
        ListNode fast = head;
        for(int i = 1 ; i <= k ; i++){ // 初始化快指针
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
