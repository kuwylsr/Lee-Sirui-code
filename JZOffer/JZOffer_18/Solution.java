package JZOffer_18;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;
        while(p != null){
            if(p.val == val){
                pre.next = p.next;
                break;
            }
            pre = p;
            p = p.next;
        }
        return hair.next;
    }
}
