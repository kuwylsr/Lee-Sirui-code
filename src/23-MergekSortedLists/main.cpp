#include <iostream>
#include <queue>
#include <vector>

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
    // 使用败者树来进行k路归并
    ListNode* mergeKLists(vector<ListNode*>& lists)
    {
        int k = lists.size(); // 所要归并的条数也就是O(lgn)O({\rm lg}n)O(lgn)。
        if (k == 0)
            return NULL;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minheap; //最小堆（用优先队列实现）
        vector<ListNode*> pList; //指针列表
        pList.resize(k);
        // 初始化最小堆的大小 以及 指针列表
        for (int i = 0; i < k; i++) {
            ListNode* p = lists[i];
            pList[i] = p;
            if (p == NULL)
                continue;
            minheap.push(pair<int, int>(p->val, i));
        }
        ListNode* r = new ListNode(-1);
        ListNode* p = r;
        while (minheap.size() != 0) {
            int val = minheap.top().first;
            cout << "val: " << val << endl;
            p->next = new ListNode(val); // 连接到结果链表
            p = p->next;
            int idx = minheap.top().second;
            minheap.pop(); //删除堆顶元素
            ListNode* temp = pList[idx]->next;
            if (temp != NULL) {
                minheap.push(pair<int, int>(temp->val, idx));
                pList[idx] = temp;
            }
        }
        return r->next;
    }
};

int main()
{
    ListNode n1(1), n2(7), n3(9);
    ListNode k1(1), k2(3), k3(4);
    ListNode t1(1), t2(5), t3(6);
    //n1.next = &n2;
    //n2.next = &n3;
    k1.next = &k2;
    k2.next = &k3;
    t1.next = &t2;
    t2.next = &t3;
    ListNode* nullP = NULL;
    vector<ListNode*> lists = { nullP, &n1 };
    Solution* S = new Solution();
    ListNode* head = S->mergeKLists(lists);
    ListNode* p = head;
    while (p != NULL) {
        cout << p->val << " -> ";
        p = p->next;
    }
    cout << endl;
    return 0;
}