#include <iostream>
#include <unordered_map>

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
    // 本人解法
    // 一遍扫描 + hashmap
    ListNode* removeNthFromEnd1(ListNode* head, int n)
    {
        unordered_map<int, ListNode*> map;
        ListNode* p = head;
        int len = 0;
        while (p != NULL) {
            map.insert(pair<int, ListNode*>(len, p));
            len++;
            p = p->next;
        }
        int index = len - n; //要删除的节点的下标
        if (index == 0) {
            p = head;
            head = p->next;
            p->next = NULL;
        } else if (index == len - 1) {
            p = map[index - 1];
            p->next = NULL;
        } else {
            p = map[index - 1];
            p->next = map[index + 1];
            map[index]->next = NULL;
        }
        return head;
    }

    //参考解法
    //一边扫描（双指针）
    ListNode* removeNthFromEnd2(ListNode* head, int n)
    {
        ListNode D(0); //定义一个哑结点D
        D.next = head;
        //定义双指针
        ListNode* p1 = &D; //初始化第一个指针指向哑结点D
        ListNode* p2;
        ListNode* temp = &D; //临时指针指向第一个节点D
        for (int i = 0; i < n; i++) { //初始化第二个指针，指向与第一个指针距离为n的节点
            temp = temp->next;
        }
        p2 = temp;
        while (p2->next != NULL) { //将p2指针指向链表最后一个节点时，退出循环
            p2 = p2->next;
            p1 = p1->next;
        }
        p1->next = p1->next->next;
        return D.next;
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
    ListNode* head = S->removeNthFromEnd2(&n1, 5);
    ListNode* p = head;
    while (p != NULL) {
        cout << p->val << ",";
        p = p->next;
    }
    cout << endl;
    return 0;
}