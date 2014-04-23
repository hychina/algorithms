#include "../util/binary_tree.h"
#include <vector>
#include <queue>
using std::vector;
using std::queue;

#define null INT_MIN

bool isSymmetric(TreeNode *left, TreeNode *right);

int main(int argc, char const* argv[])
{
    int arr[] = {1,2,2,3,null,null,3};
    vector<int> values(std::begin(arr), std::end(arr));

    BinaryTree tree(values);
    tree.printTree();
    TreeNode* root = tree.getRoot();
    bool is_sym = isSymmetric(root->left, root->right);
    if (is_sym) printf("true\n");
    else printf("false\n");
}

bool isSymmetric(TreeNode *left, TreeNode *right) {
    if (left == NULL && right == NULL) return true;
    if (left == NULL || right == NULL) return false;
    if (left->val != right->val) return false;
    if (!isSymmetric(left->left, right->right)) return false;
    if (!isSymmetric(left->right, right->left)) return false;
    return true;
}
