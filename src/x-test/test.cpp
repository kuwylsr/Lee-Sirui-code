#include <iostream>
#include <string> 
#include <cstring>
#include <vector>
#include <queue>

using namespace std;

struct ListNode{
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

int main(){


    queue<ListNode*> q;
    ListNode *n = new ListNode(1);
    n -> next = q.front();
    if(q.front() == NULL){
        cout << 0 << endl;
    }
}
