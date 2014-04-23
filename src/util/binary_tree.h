#ifndef BINARY_TREE_H
#define BINARY_TREE_H

#include <vector>
#include <functional>
using std::vector;
using std::function;

struct TreeNode {
    int val;
    int depth;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class BinaryTree {
    private:
        TreeNode *root;
        vector<int> values;
        std::vector<int>::const_iterator it;
        TreeNode* buildNode();
    public:
        BinaryTree();
        BinaryTree(vector<int> values);
        void preOrderTraverse(std::function<void(TreeNode*)> handle);
        void printTree();
        TreeNode* getRoot() {return this->root;};
};

#endif
