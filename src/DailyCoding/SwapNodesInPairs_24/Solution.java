package DailyCoding.SwapNodesInPairs_24;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class Solution {
    
    // 个人解法:迭代
    public ListNode swapPairs(ListNode head) {
        ListNode hair = new ListNode(-1);
        ListNode p = head;
        ListNode ppr = hair,pps;
        while(p != null && p.next != null){ // 起码有两个节点才交换
            ppr.next = p.next;

            pps = p.next.next; //记录后继

            p.next.next = p; //交换两个节点
            p.next = pps;

            ppr = p; //更新ppr
            p = pps; //更新p
        }
        if(p != null){ // 最后多出一个节点,直接连接上
            ppr.next = p;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        
    }
}
