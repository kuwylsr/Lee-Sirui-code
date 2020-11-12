package DataStructure.LinkedList.IntersectionOfTwoLinkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // 官方题解 : 双指针
    // 时间复杂度: O(n + m)
    // 空间复杂度 : O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //1表示指针在遍历链表1, 0表示在遍历链表2

        int flagA = 1; 
        int flagB= 0;

        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != null || pB != null){
            if(pA == null){
                if(flagA == 1){ //如果pA遍历完链表1了,则转向遍历链表2
                    pA = headB;
                    pB=pB.next;
                    flagA = 0;
                }else if (flagA == 0){ //如果pA遍历完链表2了,则说明没有交点
                    return null;
                }
            }else if (pB == null){ 
                if(flagB == 0){ //如果pB遍历完链表2了,则转向遍历链表1
                    pB = headA;
                    pA = pA.next;
                    flagB = 1;
                }else if (flagB == 1){ //如果pB遍历完链表1了,则说明没有交点
                    return null;
                }
            }else{
                if(pA == pB){
                    return pA;
                }else{
                    pA = pA.next;
                    pB = pB.next;
                }
            }
        }
        return null; 
    }

    // 哈希表 : 没啥意思..
}
