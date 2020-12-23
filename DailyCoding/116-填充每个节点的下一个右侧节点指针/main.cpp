#include <cmath>
#include <iostream>
#include <queue>

using namespace std;

class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node()
        : val(0)
        , left(NULL)
        , right(NULL)
        , next(NULL)
    {
    }

    Node(int _val)
        : val(_val)
        , left(NULL)
        , right(NULL)
        , next(NULL)
    {
    }

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val)
        , left(_left)
        , right(_right)
        , next(_next)
    {
    }
};

class Solution {
public:
    // 个人解法：广度搜索
    Node* connect(Node* root)
    {
        queue<Node*> q;
        q.push(root);
        int height = 0;
        Node* n1;
        while (!q.empty()) {
            for (int i = 0; i < pow(2, height); i++) { //每层树的节点数 按 2 的指数增长
                n1 = q.front();
                q.pop();
                if (i != pow(2, height) - 1) { // 若不为本层最后一个元素
                    n1->next = q.front();
                }
                if (n1 == NULL)
                    continue;
                if (n1->left != NULL) {
                    q.push(n1->left);
                }
                if (n1->right != NULL) {
                    q.push(n1->right);
                }
            }
            height += 1;
        }
        return root;
    }

    // 评论区解法：递归求解
    void Recursion(Node* root)
    {
        if (root == NULL || root->left == NULL) { //该节点为空 或者 该节点没有下一层时(完美二叉树，没有左儿子就没有下一层) return
            return;
        }
        root->left->next = root->right;
        if (root->next != NULL) {
            root->right->next = root->next->left; //重点，不容易想到
        }
        Recursion(root->left);
        Recursion(root->right);
    }

    Node* connect2(Node* root)
    {
        Recursion(root);
        return root;
    }

    // 评论区：常数空间的广度优先搜索
    Node* connect(Node* root)
    {
        if (root == nullptr)
            return root;
        Node* curlevel = root;
        Node* cur = curlevel;
        while (curlevel) {
            cur = curlevel;
            while (cur) {
                if (cur->left) {
                    cur->left->next = cur->right;
                    if (cur->next)
                        cur->right->next = cur->next->left;
                } else {
                    break;
                }
                cur = cur->next;
            }
            curlevel = curlevel->left;
        }
        return root;
    }
};

int main()
{

    return 0;
}