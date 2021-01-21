package JZOffer_25;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(-1);
        ListNode p = hair;
        while(l1 != null || l2 != null){
            if(l1 == null){
                p.next = l2;
                break;
            }else if(l2 == null){
                p.next = l1;
                break;
            }else{
                if(l1.val < l2.val){
                    p.next = l1;
                    l1 = l1.next;
                }else{
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
        }
        return hair.next;
    }
}
