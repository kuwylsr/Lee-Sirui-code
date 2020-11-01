                                                                                                                                            #include<iostream>

using namespace std;

class Node{
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next) : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution {
public:

    // 个人解法：递归
    void Recursion(Node* root){
        if(root == NULL){
            return ;
        }
        if(root->left != NULL){
            if(root->right != NULL){
                root->left->next = root->right;
            }else{
                Node *p = root;
                while(p->next != NULL){ //横向一直找
                    if(p->next->left != NULL){
                        root->left->next = p->next->left;
                        break;
                    }else if(p->next->right != NULL){
                        root->left->next = p->next->right;
                        break;
                    }else{
                        p = p->next;
                    }
                }  
            } 
        }
        if(root->right!=NULL){
            Node *p = root;
            while(p->next != NULL){
                if(p->next->left != NULL){ //横向一直找
                    root->right->next = p->next->left;
                    break;
                }else if(p->next->right != NULL){
                    root->right->next = p->next->right;
                    break;
                }else{
                    p = p->next;
                }
            } 
        }
        // 本题递归法的重点，一定要先遍历右侧，避免左侧计算next指针的时候，右侧的节点还有没计算到，造成错误
        Recursion(root->right);
        Recursion(root->left);
    }

    Node* connect(Node* root) {
        Recursion(root);
        return root;
    }

    // 参考答案：常熟空间，利用已有next指正
    void handle(Node* &last, Node* &p, Node* &nextStart) {
        if (last) {
            last->next = p;
        } 
        if (!nextStart) {
            nextStart = p;
        }
        last = p;
    }

    Node* connect(Node* root) {
        if (!root) {
            return nullptr;
        }
        Node *start = root;
        while (start) {
            Node *last = nullptr, *nextStart = nullptr;
            for (Node *p = start; p != nullptr; p = p->next) {
                if (p->left) {
                    handle(last, p->left, nextStart);
                }
                if (p->right) {
                    handle(last, p->right, nextStart);
                }
            }
            start = nextStart;
        }
        return root;
    }
};

int main(){

    return 0;
}