package JZOffer_24;


class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // 个人解法 : 迭代 + 指针
    public ListNode reverseList(ListNode head) {
        ListNode hair = null; //设置一个哑节点
        ListNode p = head;
        if(p == null){
            return p;
        }
        ListNode post = p.next;
        ListNode pre = hair;

        while(p != null){
            p.next = pre;

            pre = p;
            p = post;
            if(p == null){
                break;
            }
            post = p.next;
        }
        return pre;
    }

    // 官方题解 : 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
