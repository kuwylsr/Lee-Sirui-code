package RemoveDuplicatesFromSortedListII_82;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair = new ListNode(-1);
        ListNode pre = hair;
        hair.next = head;
        ListNode p = head;
        if(p == null || p.next == null){
            return p;
        }
        ListNode post = p.next;

        while(p != null && post != null){
            if(p.val == post.val){
                while(post.next != null){
                    if(post.val == post.next.val){
                        post = post.next;
                    }else{
                        break;
                    }
                }
                pre.next = post.next;
                p = pre.next;

                if(p != null){
                    post = p.next;
                }
            }else{
                pre = p;
                p = p.next;
                if(p != null){
                    post = p.next;
                }
            }
        }
        return hair.next;
    }
}
