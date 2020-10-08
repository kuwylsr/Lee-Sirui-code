#include <iostream>

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
private:
    int sum = 0;

public:
    int minCameraCover(TreeNode* root)
    {
        if (root == NULL) {
            return 0;
        }
        int root_state = dfs(root);
        if (root_state == 2) {
            sum += 1;
        }
        return sum;
    }

    /**
     * 后序遍历(左->右->根)，深度优先，函数返回该参数节点的状态
     * 
     * 每个树节点设置共有三种状态
     * 0：代表该节点安装了监视器
     * 1：代表该节点可被监测，但没有安装监视器
     * 2：代表该节点不可观
     */
private:
    int dfs(TreeNode* root)
    {
        if (root == NULL) { // 节点为空，我们认为它可观，但无监视器
            return 1;
        }
        int left_state = dfs(root->left);
        int right_state = dfs(root->right);
        if (left_state == 2 || right_state == 2) { //儿子们至少存在一个不可观
            sum += 1;
            return 0;
        } else if (left_state == 0 || right_state == 0) { // 儿子们至少存在一个监视器
            return 1;
        } else {
            return 2;
        }
    }
};

int main()
{
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
    int result = S->minCameraCover(root);
    cout << result << endl;
    return 0;
}