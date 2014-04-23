#include "binary_tree.h"
#include <queue>
#include <limits.h>
#include <stdio.h>
#include <stack>
#include <functional>
using std::queue;
using std::stack;

void BinaryTree::printTree() {
    preOrderTraverse([] (TreeNode* node) {
            for (int i = 0; i < node->depth; ++i)
            printf("  ");
            printf("%d\n", node->val);
            });
}

void BinaryTree::preOrderTraverse(std::function<void(TreeNode*)> handle) {
    if (this->root == NULL) return;
    stack<TreeNode*> s;
    s.push(this->root);
    while (!s.empty()) {
        TreeNode *top = s.top();
        s.pop();
        handle(top);

        TreeNode *left = top->left;
        TreeNode *right = top->right;

        if (right != NULL) s.push(right);
        if (left != NULL) s.push(left);
    }
}

TreeNode* BinaryTree::buildNode() {
    TreeNode *node = NULL;
    if (it != values.end()) {
        if (*it != INT_MIN)
            node = new TreeNode(*it);
        it++;
    }
    return node;
}

BinaryTree::BinaryTree(vector<int> values) {
    this->values = values;
    this->it = this->values.begin();

    queue<TreeNode*> q;
    this->root = buildNode();
    this->root->depth = 0;
    q.push(this->root);

    int depth = 0;
    while (!q.empty()) {
        TreeNode *node = q.front();
        q.pop();
        if (node == NULL) continue;

        TreeNode *left = buildNode();
        TreeNode *right = buildNode();
        node->left = left;
        node->right = right;
        depth = node->depth + 1;
        if (left != NULL) {left->depth = depth; q.push(left);}
        if (right != NULL) {right->depth = depth; q.push(right);}
    }
}
