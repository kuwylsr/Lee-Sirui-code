#include <iostream>
#include <stack>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x)
        : val(x)
        , left(NULL)
        , right(NULL)
    {
    }
};

class Solution {
public:
    TreeNode* createTree(vector<int>& values){
        
    }

    // 个人解法：非递归深度优先搜索
    TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2)
    {
        stack<TreeNode*> s;
        if (t1 == NULL){
            return t2;
        }else if (t2 == NULL){
            return t1;
        }else{ // 一次性压入两个元素
            s.push(t1);
            s.push(t2);
        }
        while(!s.empty()){
            // 取出栈顶的两个元素
            TreeNode* n2 = s.top();
            s.pop();
            TreeNode* n1 = s.top();
            s.pop();
            if(n1 == NULL || n2 == NULL){ //如果一方为空，则可以不用合并（其实下面的做法已经保证了n1不会为空）
                continue;
            }
            n1->val = n1->val + n2->val;
            //若tree1的儿子节点为空，则添加一个新节点(保证下一个n1不会为空)
            if(n1->right == NULL && n2->right != NULL){ 
                n1->right = new TreeNode(0);
            }
            if(n1->left == NULL && n2->left != NULL){
                n1->left = new TreeNode(0);
            }
            s.push(n1->right);
            s.push(n2->right);
            s.push(n1->left);
            s.push(n2->left);
        }
        return t1;
    }

    // 参考答案：递归深度优先搜索
    TreeNode* mergeTrees2(TreeNode* t1, TreeNode* t2){
        
        if(t1 == NULL){
            return t2;
        }
        if(t2 == NULL){
            return t1;
        }
        TreeNode *p = new TreeNode(t1->val + t2->val);
        p->left = mergeTrees2(t1->left, t2->left);
        p->right = mergeTrees2(t1->right, t2->right);
        return p;

    }
};

int main()
{

    return 0;
}