#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL){}
};

class Solution {
    public:
        //简介版算法
        ListNode* addTwoNumbers1(ListNode* l1, ListNode* l2){
            ListNode* result = new ListNode(0);
            ListNode* p = l1;
            ListNode* q = l2;
            ListNode* curr = result;
            int overflow = 0;
            while(p != NULL || q != NULL){
                int num1 = (p != NULL) ? p->val : 0;
                int num2 = (q != NULL) ? q->val : 0;
                int sum = overflow + num1 + num2;
                overflow = sum / 10;
                curr->next = new ListNode(sum%10);
                curr = curr->next;
                if(p != NULL){
                    p = p->next;
                }
                if(q != NULL){
                    q = q->next;
                }
            }
            if(overflow > 0){
                curr->next = new ListNode(overflow);
            }
            return result->next;
        }
        //个人算法
        ListNode* addTwoNumbers2(ListNode* l1, ListNode* l2){
            int overflow = 0; //进位
            int num1 = 0, num2 = 0; //两个列表的目标位
            int num = 0; //两个列表目标位+进位的和
            int init_val = l1->val + l2->val;
            if(init_val != init_val%10){
                init_val = init_val % 10;
                overflow = 1;
            }
            ListNode *init_l = new ListNode(init_val);
            ListNode *templ = init_l;
            while(true){
                l1 = l1->next;
                l2 = l2->next;
                if(l1 == NULL && l2 == NULL){ //两个列表都已遍历完成
                    if(overflow == 1){
                        templ->next = new ListNode(1);
                    }
                    return init_l;
                }else if(l1 == NULL && l2 != NULL){ //l2列表遍历率先遍历完成，在其后补0
                    l1 = new ListNode(0);
                    num2 = l2->val;
                }else if(l1 != NULL && l2 == NULL){ //l1列表遍历率先遍历完成，在其后补0
                    l2 = new ListNode(0);
                    num1 = l1->val;
                }else{
                    num1 = l1->val;
                    num2 = l2->val;
                }
                num = num1 + num2 + overflow;
                if(num != num % 10){
                    templ->next = new ListNode(num%10);
                    overflow = 1;
                }else{
                    templ->next = new ListNode(num);
                    overflow = 0;
                }
                templ = templ->next;
                num1 = 0;
                num2 = 0;
                num = 0; 
            }
            return init_l;
        }
};

int main(){
    ListNode *l1 = new ListNode(2);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(3);

    ListNode *l2 = new ListNode(5);
    l2->next = new ListNode(6);
   // l2->next->next = new ListNode(4);

    Solution *s = new Solution();
    ListNode *result = s->addTwoNumbers2(l1,l2);
    while(result != NULL){
        cout << result->val << " -> ";
        result = result->next;
    }
    cout << "end" << endl;
    cout << "hello world " << endl;
    return 0;
}