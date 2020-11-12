package DataStructure.LinkedList.ReverseLinkedList_206;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode hair = null;
        ListNode pre = hair;
        ListNode p = head;
        if(head == null){
            return null;
        }
        ListNode post= head.next;
        while(p != null){
            p.next = pre;
            
            pre = p;
            p = post;
            if(post != null){
                post = post.next;
            }
            
        }
        return pre;
    }
}
