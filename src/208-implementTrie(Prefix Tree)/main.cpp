#include <iostream>
#include <vector>

using namespace std;

// 前缀树的树节点
class TrieNode {
    // member variables
private:
    vector<TrieNode*> links; //所链接的键值
    int R = 26; //所有小写英文字母的个数
    bool isEnd; //此树节点是否为某个字符串的结尾

public:
    // Initialize data structure
    TrieNode()
    {
        links.resize(R);
        isEnd = false;
    }

    // 判断该节点是否包含某一键值（字符）
    bool containKey(char ch)
    {
        return links[ch - 'a'] != NULL;
    }

    //给某个树节点赋予键值
    void put(char ch, TrieNode* node)
    {
        links[ch - 'a'] = node;
    }

    //获取某个键值节点的下一个节点
    TrieNode* get(char ch)
    {
        return links[ch - 'a'];
    }

    //设置该树节点为某个字符串的结尾
    void setEnd(bool f)
    {
        isEnd = f;
    }

    //返回该树节点是否为某个字符串的结尾
    bool getEnd()
    {
        return isEnd;
    }
};

// 前缀树
class Trie {
    // member variables
private:
    TrieNode* root; //根节点

public:
    /** Initialize your data structure here. */
    Trie() { root = new TrieNode(); }

    /** Inserts a word into the trie. */
    void insert(string word)
    {
        TrieNode* p = root;
        for (char c : word) {
            if (!p->containKey(c)) {
                TrieNode* temp = new TrieNode();
                p->put(c, temp);
            }
            p = p->get(c);
        }
        p->setEnd(true);
    }

    /** Returns if the word is in the trie. */
    bool search(string word)
    {
        TrieNode* p = root;
        for (char c : word) {
            if (!p->containKey(c)) {
                return false;
            }
            p = p->get(c);
        }
        if (p->getEnd() && p != NULL) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given
   * prefix. */
    bool startsWith(string prefix)
    {
        TrieNode* p = root;
        for (char c : prefix) {
            if (!p->containKey(c)) {
                return false;
            }
            p = p->get(c);
        }
        if (p != NULL) {
            return true;
        } else {
            return false;
        }
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */

int main()
{
    Trie *tree = new Trie();
    tree->insert("lisirui");
    cout << tree->search("lisirui") << endl;
    cout << tree->startsWith("lisi") << endl;
    cout << tree->search("lisitui") << endl;
    cout << tree->startsWith("liti") << endl;
    return 0;
}