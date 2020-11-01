#include <iostream>

using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x)
        : val(x)
        , next(NULL)
    {
    }
};

class Solution {
public:
    //类似于归并排序
    ListNode* mergeTwoLists1(ListNode* l1, ListNode* l2)
    {
        ListNode* p1 = l1;
        ListNode* p2 = l2;
        ListNode D(0); // 定义一个哑结点（哨兵节点）
        ListNode* p = &D;
        while (p1 != NULL && p2 != NULL) {
            if ((p1->val) < (p2->val)) {
                p->next = p1;
                p1 = p1->next;
            } else {
                p->next = p2;
                p2 = p2->next;
            }
            p = p->next;
        }
        // 当一个列表遍历完毕之后，目标链表直接连接另一个剩余的链表
        if (p1 == NULL) {
            p->next = p2;
        } else {
            p->next = p1;
        }
        return D.next;
    }

    //递归
    ListNode* mergeTwoLists2(ListNode* l1, ListNode* l2)
    {
        //(递归树的叶子节点函数的)（向下的过程中的）递归终止条件(分到什么时候结束)
        if (l1 == NULL)
            return l2;
        if (l2 == NULL)
            return l1;

        //(递归树的非叶子节点函数的)（向上的过程中的）递归终止条件(合并叶子函数)
        if (l1->val <= l2->val) {
            ListNode* p = mergeTwoLists2(l1->next, l2);
            l1->next = p;
            return l1;
        } else {
            ListNode* p = mergeTwoLists2(l1, l2->next);
            l2->next = p;
            return l2;
        }
    }
};

int main()
{
    ListNode n1(1), n2(2), n3(4);
    ListNode k1(1), k2(3), k3(4);
    n1.next = &n2;
    n2.next = &n3;
    k1.next = &k2;
    k2.next = &k3;
    Solution* S = new Solution();
    ListNode* head = S->mergeTwoLists1(&n1, &k1);
    ListNode* p = head;
    while (p != NULL) {
        cout << p->val << ",";
        p = p->next;
    }
    cout << endl;
    return 0;
    return 0;
}