#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

struct TreeNode{
    int val;
    TreeNode * left;
    TreeNode * right;
    TreeNode(int x) : val(x), left(NULL),right(NULL) {}
};

class Solution {
public:

    unordered_map<int,int> m; //用于存储中序遍历序列中，值到下标的映射
    int pre_index; // 用于记录当前子树根的下标(在先序序列中得到)

    TreeNode* Recursion(int left,int right, vector<int>& preorder, vector<int>& inorder){
        if(left > right){
            return NULL;
        }

        int rootVal = preorder[pre_index];
        TreeNode *curRoot = new TreeNode(rootVal);
        pre_index += 1;

        int rootIndexInInorder = m[rootVal];
        curRoot -> left = Recursion(left,rootIndexInInorder-1,preorder,inorder);
        curRoot -> right = Recursion(rootIndexInInorder+1,right, preorder,inorder);
        return curRoot;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int node_num = preorder.size();
        pre_index = 0;
        for(int i = 0; i < node_num;i++){
            m.insert(make_pair(inorder[i],i));
        }
        TreeNode* root = Recursion(0,node_num-1,preorder,inorder);
        return root;
    }
};

int main(){

    return 0;
}