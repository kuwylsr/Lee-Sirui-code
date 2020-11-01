#include <iostream>

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
    // 个人解法
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        TreeNode *p = root;
        if(p == NULL) return new TreeNode(val);
        while(p != NULL) {
            if(p->val > val){
                if(p->left == NULL){
                    p->left = new TreeNode(val);
                    return root;
                }else{
                    p = p->left;
                }
            }else if(p->val < val){
                if(p->right == NULL){
                    p->right = new TreeNode(val);
                    return root;
                }else{
                    p = p->right;
                }
            }
        }
        return root;
    }

    // 网友解法 dfs
    TreeNode* insertIntoBST2(TreeNode* root,int val){
        if(root == NULL){
            return new TreeNode(val);
        }
        TreeNode *p = root;
        if(p->val > val){
            p->left = insertIntoBST2(p->left,val);
        }else{
            p->right = insertIntoBST2(p->right,val);
        }
        return root;
    }
};

int main(){

    return 0;
}