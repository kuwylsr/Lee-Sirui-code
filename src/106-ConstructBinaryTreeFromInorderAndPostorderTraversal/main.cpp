#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    bool isVisited;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x)
        : val(x)
        , isVisited(false)
        , left(NULL)
        , right(NULL)
    {
    }
};

class Solution {
public:
    unordered_map<int, int> m1; //来记录inorder中，每个元素的值 及其 在集合中的下标。方便得到某个值的下标
    int post_index; //用于记录在后序遍历集合中，当前子树根的下标

    // unordered_map<int, int> m2; //来记录postorder中，每个元素的值 及其 在集合中的下标。方便得到某个值的下标

    TreeNode* Recursion(int left, int right, vector<int>& inorder, vector<int>& postorder)
    {
        if (left > right) { //若没有节点，直接返回NULL值
            return NULL;
        }
        int rootVal = postorder[post_index];
        TreeNode* curRoot = new TreeNode(rootVal);
        post_index -= 1; //post_index 不断向左移动，正好也正是从右到左 每颗子树的根 !!!!!!!! 重点
        // 如果没有发现这一特点，你就需要找到当前 inorder[left,right] 中，在 postorder 下标最大的点, 就是下一颗子树的根（很麻烦）

        int rootIndexInInorder = m1[rootVal];

        // 先右 再左，因为post_index 是从后往前移动(根->右->左)，先遍历到的是 右子树的根
        curRoot->right = Recursion(rootIndexInInorder + 1, right, inorder, postorder);
        curRoot->left = Recursion(left, rootIndexInInorder - 1, inorder, postorder);

        return curRoot; 
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder)
    {
        int node_num = inorder.size();
        post_index = node_num - 1; // 最开始的根节点 一定为 postorder 的最后一个元素
        for (int i = 0; i < inorder.size(); i++) {
            m1.insert(make_pair(inorder[i], i));
        }
        TreeNode* root = Recursion(0, node_num - 1, inorder, postorder);
        return root;
    }
};

int main()
{

    return 0;
}