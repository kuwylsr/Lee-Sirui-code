#include<iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x),next(NULL) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head){
        ListNode* pre = NULL;
        ListNode* p = head;
        if (p == NULL) return head;
        ListNode* nex = p ->next; //一定要注意记录要失去连接的节点

        while(p != NULL){
            p->next = pre;
            pre = p;
            p = nex;
            if(p == NULL) break;
            nex = p ->next;
        }
        return pre;
    }
};

int main(){
    ListNode n1(1), n2(2), n3(3), n4(4), n5(5);
    n1.next = &n2;
    n2.next = &n3;
    n3.next = &n4;
    n4.next = &n5;

    Solution* S = new Solution();
    ListNode* head = S->reverseList(&n1);
    ListNode* p = head;
    while (p != NULL) {
        cout << p->val << " -> ";
        p = p->next;
    }
    cout << endl;

    return 0;
    return 0;
}