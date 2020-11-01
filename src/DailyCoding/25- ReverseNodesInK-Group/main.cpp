#include <iostream>

using namespace std;

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
    // 个人解法
    ListNode* reverseKGroup(ListNode* head, int k)
    {
        // 递归终止条件，当要处理的链表节点个数小于k
        ListNode* p = head;
        int num = 0;
        while (p != NULL) {
            num += 1;
            if (num == k)
                break;
            p = p->next;
        }
        if (num < k || k == 1) {
            return head;
        }
        ListNode* nextp = p->next;
        ListNode* firstNode = head;
        ListNode* secondNode = head->next;

        // 翻转k个节点
        ListNode* pre = head;
        ListNode* cur = secondNode;
        ListNode* tmp1 = new ListNode(-1);
        ListNode* tmp2 = new ListNode(-1);
        for (int i = 1; i < k; i++) {
            tmp1 = cur;
            tmp2 = cur->next;
            cout << cur->val << endl;
            cout << pre->val << endl;

            cur->next = pre;
            pre = tmp1;
            cur = tmp2;
        }

        firstNode->next = reverseKGroup(nextp, k); //与下k个相连

        return p;
    }

    // 答案题解

    // 翻转一个子链表，并且返回新的头与尾
    pair<ListNode*, ListNode*> myReverse(ListNode* head, ListNode* tail)
    {
        ListNode* prev = tail->next;
        ListNode* p = head;
        while (prev != tail) {
            ListNode* nex = p->next; //一定要注意记录要失去连接的节点
            p->next = prev;
            prev = p;
            p = nex;
        }
        return { tail, head };
    }

    ListNode* reverseKGroup2(ListNode* head, int k)
    {
        ListNode* hair = new ListNode(-1); // 在head节点前再加一个hair节点
        hair->next = head;
        ListNode* pre = hair;

        while (head) {
            ListNode* tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail->next;
                if (!tail) {
                    return hair->next;
                }
            }

            ListNode* nex = tail->next; //一定要注意记录要失去连接的节点，也就是tail的下一个节点，因为马上tail就要翻转往回指了。
            pair<ListNode*, ListNode*> result = myReverse(head,tail);
            head = result.first;
            tail = result.second;
            // 把子链表重新接回原链表上
            pre->next =head;
            tail ->next = nex;
            pre = tail;
            head = nex;
        }
        return hair->next;
    }
};

int main()
{
    ListNode n1(1), n2(2), n3(3), n4(4), n5(5);
    n1.next = &n2;
    n2.next = &n3;
    n3.next = &n4;
    n4.next = &n5;

    Solution* S = new Solution();
    int k = 4;
    ListNode* head = S->reverseKGroup2(&n1, k);
    ListNode* p = head;
    while (p != NULL) {
        cout << p->val << " -> ";
        p = p->next;
    }
    cout << endl;

    return 0;
}