package DailyCoding.ReorderList_143;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // 个人解法:利用线性表存储 ListNode
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        ArrayList<ListNode> node_list = new ArrayList<ListNode>();
        node_list.add(head);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            node_list.add(p);
        }

        int len = node_list.size();
        int index = len - 1;
        ListNode p_tail = node_list.get(index);
        ListNode p_head = head;
        ListNode p_head_post = null;
        while (p_head != p_tail && p_head.next != p_tail) {
            p_head_post = p_head.next;
            p_head.next = p_tail;
            p_tail.next = p_head_post;

            p_head = p_head_post;
            p_head_post = p_head.next;
            index--;
            p_tail = node_list.get(index);
        }
        if (p_head == p_tail) {
            p_head.next = null;
        } else {
            p_tail.next = null;
        }
    }
// ----------------------------------------------------------------------------
    // 官方题解: 寻找链表中点 + 链表逆序 + 合并链表

    /**
     * 查找链表中的中间结点
     * @param head
     * @return
     */
    public ListNode findMidOfList(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = head.next; // 快指针(比慢指针步伐大1)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode hair = null;
        ListNode pre = hair;
        ListNode p = head;
        if (head == null) {
            return null;
        }
        ListNode post = head.next;
        while (p != null) {
            p.next = pre;

            pre = p;
            p = post;
            if (post != null) {
                post = post.next;
            }
        }
        return pre;
    }

    /**
     * 合并链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        if(p1 == null){
            return p2;
        }
        if(p2 == null){
            return p1;
        }
        ListNode p1_post = p1.next;
        ListNode p2_post = p2.next;
        while(p1 != null && p2 != null){
            p1.next = p2;
            p2.next = p1_post;

            p1 = p1_post;
            p2 = p2_post;
            if(p1_post != null){
                p1_post = p1_post.next;
            }
            if(p2_post != null){
                p2_post = p2_post.next;
            }
        }
        return head1;
    }
    
    public void reorderList2(ListNode head) {
        if(head == null){
            return;
        }
        ListNode midNode = findMidOfList(head);
        ListNode head2 = midNode.next;
        midNode.next = null;
        ListNode reverseHead2 = reverseList(head2);
        ListNode ans = mergeList(head,reverseHead2);
        head = ans;
    }
}
