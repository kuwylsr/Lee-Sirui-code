#include<iostream>

using namespace std;

struct TreeNode{
    int val;
    TreeNode * left;
    TreeNode * right;
    TreeNode(int x) : val(x), left(NULL),right(NULL) {}
};

class Solution {
public:
    // 个人解法：先序遍历
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root != NULL){
            int val = root->val;
            if((val >= p->val && val <= q->val) || (val <= p->val && val >= q->val)){ //先序遍历，只要当前p 和 q 比cur 一个小，一个大，则
                return root;
            }
            TreeNode *r1 = lowestCommonAncestor(root->left,p,q);
            if(r1 != NULL) return r1;
            TreeNode *r2 = lowestCommonAncestor(root->right,p,q);
            if(r2 != NULL) return r2;
            return NULL;
        }else{
            return NULL;
        }
    }

    // 参考答案：按照题目要求进行遍历求解
    TreeNode* lowestCommonAncestor2(TreeNode* root, TreeNode* p, TreeNode* q){
        while(root != NULL){
            int target_val = root->val;
            if(p->val < target_val && q->val < target_val){ //如果当前节点的值 比p q两个值都大，则p q一定都在其左子树中
                root = root -> left;
            }else if(p->val > target_val && q->val > target_val){  //如果当前节点的值 比p q两个值都小，则p q一定都在其右子树中
                root = root -> right;
            }else{ // 若不属于上面两种情况，说明已经出现了岔路口，p q 一个在左一个在右，此时即为最近（深度最深的）公共祖先
                return root;
            }
        }
        return root;
    }
};