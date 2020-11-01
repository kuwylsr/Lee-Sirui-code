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
    // 个人解法 利用两个指针(分别指向奇数和偶数)
    ListNode* swapPairs1(ListNode* head)
    { 
        ListNode* p1 = head;
        ListNode* p2 = NULL;
        if(head != NULL){
            p2 = head->next;
        }
        if(p2 == NULL) return p1;
        ListNode* r = p2; // 返回结果的头指针
        while (p1 != NULL && p2 != NULL) {
            if (p2 -> next == NULL){ //处理链表中只有两个节点的情况
                p2 -> next = p1;
                p1 -> next = NULL;
                break;
            } else {
                ListNode* tmp1 = p1->next->next;
                ListNode* tmp2 = p2->next->next;

                if(p1->next->next->next == NULL){ //如果是奇数个节点
                    p1->next = p1->next->next;
                }else{ //偶数
                    p1->next = p1->next->next->next;
                }
                p2->next = p1;

                p1 = tmp1;
                p2 = tmp2;
            } 
        }
        return r;
    }

    // 官方解答1 递归
    ListNode* swapPairs2(ListNode* head)
    {
        // 链表少于两个节点(递归终止条件)
        if (head == NULL || head->next == NULL){
            return head;
        }

        // 链表多于两个节点，则可以进行交换
        // 要被交换的两个节点
        ListNode* firstNode = head;
        ListNode* secondNode = head->next;

        // 进行交换
        firstNode->next = swapPairs2(secondNode->next);
        secondNode->next = firstNode;

        // 返回头结点
        return secondNode;
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
    ListNode* head = S->swapPairs2(&n1);
    ListNode* p = head;
    while (p != NULL) {
        cout << p->val << " -> ";
        p = p->next;
    }
    cout << endl;

    return 0;
}