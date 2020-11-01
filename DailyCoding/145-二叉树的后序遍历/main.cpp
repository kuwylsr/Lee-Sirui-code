#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode()
        : val(0)
        , left(nullptr)
        , right(nullptr)
    {
    }
    TreeNode(int x)
        : val(x)
        , left(nullptr)
        , right(nullptr)
    {
    }
    TreeNode(int x, TreeNode* left, TreeNode* right)
        : val(x)
        , left(left)
        , right(right)
    {
    }
};

class Solution {
public:
    vector<int> result;
    
    // 个人解法：递归
    void postorder(TreeNode* root){
        if(root != NULL){
            postorder(root->left);
            postorder(root->right);
            result.push_back(root->val);
        }
    }
    vector<int> postorderTraversal(TreeNode* root) {
        postorder(root);
        return result;
    }


    // 迭代
    vector<int> postorderTraversal2(TreeNode* root) {
        stack<pair<TreeNode*,bool>> s;
        s.push(make_pair(root,false));
        while(!s.empty()){
            TreeNode *p = s.top().first;
            bool isVisited = s.top().second;
            s.pop();
            if(p == NULL){
                continue;
            }
            if(isVisited){
                result.push_back(p->val);
            }else{ // 注意栈的顺序与 遍历顺序相反
                s.push(make_pair(p,true)); // 根
                s.push(make_pair(p->right,false)); // 右
                s.push(make_pair(p->left,false)); // 左
            }
        }
        return result;
    }
};

int main(){

    return 0;
}