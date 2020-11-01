#include<iostream>
#include<stack>

using namespace std;

struct TreeNode  {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL),right(NULL) {}
};

// 复习一下二叉树的遍历（前中后 序 遍历）
class Review{ 
public:
// --------------------------- 递归算法-------------------------------
    // 前序遍历 (根 -> 左 -> 右)
    void preorder(TreeNode *root){
        if(root != NULL){
            cout << root->val <<endl;
            preorder(root->left);
            preorder(root->right);
        }
    }

    // 中序遍历 (左 -> 根 -> 右)
    void inorder(TreeNode *root){
        if(root != NULL){
            inorder(root->left);
            cout << root->val <<endl;
            inorder(root->right);
        }
    }

    // 后序遍历 (左 -> 右 -> 根)
    void postorder(TreeNode *root){
        if(root != NULL){
            postorder(root->left);
            postorder(root->right);
            cout << root->val <<endl;
        }
    }

// --------------------------- 非递归算法-------------------------------
    // 前序遍历 (根 -> 左 -> 右)
    void preorderNew(TreeNode *root){
        stack<TreeNode*> s;
        s.push(root);
        while(!s.empty()){
            root = s.top();
            s.pop();
            if(root == NULL){
                continue;
            }else{
                cout << root->val <<endl;
                s.push(root->right);
                s.push(root->left);
            }
        }
    }

    // 中序遍历 (左 -> 根 -> 右)
    void inorderNew(TreeNode *root){
        stack<pair<TreeNode*, bool>> s;
        s.push(make_pair(root,false));
        bool isVisited;
        while(!s.empty()){
            root = s.top().first;
            isVisited = s.top().second;
            s.pop();
            if(root == NULL){
                continue;
            }
            if(isVisited){
                cout << root -> val <<endl;
            }else{
                s.push(make_pair(root->right, false));
                s.push(make_pair(root,true));
                s.push(make_pair(root->left, false));
            }
        }
    }

    // 后序遍历 (左 -> 右 -> 根)
    void postorderNew(TreeNode *root){
        stack<pair<TreeNode*, bool>> s;
        s.push(make_pair(root,false));
        bool isVisited;
        while(!s.empty()){
            root = s.top().first;
            isVisited = s.top().second;
            s.pop();
            if(root == NULL){
                continue;
            }
            if(isVisited){
                cout << root -> val <<endl;
            }else{
                s.push(make_pair(root,true));
                s.push(make_pair(root->right, false));
                s.push(make_pair(root->left, false));
                
            }
        }
    }

};

class Solution {
public:
    // 个人解法(递归，类似于中序遍历(反过来)(右 -> 根 -> 左))
    int sum = 0;
    TreeNode* convertBST(TreeNode* root) {
        if(root != NULL){
            convertBST(root->right);
            root->val += sum;
            sum = root->val;
            convertBST(root->left);
        }
        return root;
    }
};

int main(){

    TreeNode *root = new TreeNode(5);

    TreeNode *l = new TreeNode(3);
    TreeNode *ll = new TreeNode(2);
    TreeNode *lr = new TreeNode(1);

    TreeNode *r = new TreeNode(10);
    TreeNode *rl = new TreeNode(9);
    TreeNode *rr = new TreeNode(13);
    root->left = l;
    root->right = r;
    l->left = ll;
    l->right = lr;
    r->left = rl;
    r->right = rr;

    Solution *S = new Solution();
    TreeNode *result = S->convertBST(root);

    Review *R = new Review();
    R->preorder(result);

// ---------------Test--------------------
    // Review *R = new Review();
    // cout << "前序遍历：" << endl;
    // R->preorder(root);
    // R->preorderNew(root);
    // cout << "中序遍历：" << endl;
    // R->inorder(root);
    // R->inorderNew(root);
    // cout << "后序遍历：" << endl;
    // R->postorder(root);
    // R->postorderNew(root);

    return 0;
}