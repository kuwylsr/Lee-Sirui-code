#include <iostream>
#include <stack>
#include <queue>


using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x),left(NULL),right(NULL){}
};

class Solution {
public:
    // 个人解法：深度优先搜索（递归）
    int sumOfLeftLeaves(TreeNode* root) {
        int sum = 0;
        TreeNode *p = root;
        if(p == NULL){
            return sum;
        }
        if(p->left != NULL){
            if(p->left->left == NULL && p->left->right == NULL){ // 判断是否为叶子节点
                sum += p->left->val;
            }
        }
        sum += sumOfLeftLeaves(p->left);
        sum += sumOfLeftLeaves(p->right);
        return sum;
    }

    // 深度优先搜索（栈）
    int sumOfLeftLeaves2(TreeNode* root) {
        int sum = 0;
        stack<TreeNode*> s;
        s.push(root);
        while(!s.empty()) {
            TreeNode *p = s.top();
            s.pop();
            if(p == NULL) continue;
            if(p->right != NULL){
                s.push(p->right);
            }
            if(p->left != NULL){ //判断其左儿子是否为左叶子
                if(p->left->left == NULL && p->left->right == NULL){ // 判断是否为叶子节点
                    sum += p->left->val;
                }else{ //如果其左儿子不是叶子节点，则压栈
                    s.push(p->left);
                }
            }
        }
        return sum;
    }

    // 广度优先搜索（队列）
    int sumOfLeftLeaves3(TreeNode* root) {
        int sum = 0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            TreeNode *p = q.front();
            q.pop();
            if(p == NULL) continue;
            if(p->left != NULL){
                if(p->left->left == NULL && p->left->right == NULL){ // 判断是否为叶子节点
                    sum += p->left->val;
                }else{ //如果其左儿子不是叶子节点，则压栈
                    q.push(p->left);
                }
            }
            if(p->right != NULL){
                q.push(p->right);
            }
        }
        return sum;
    }
};

int main() {


    return 0;
}