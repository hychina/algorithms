#include <iostream>

#define NULL 0

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode *mergeLists(ListNode *l1, ListNode *l2) {
    ListNode *left = l1;
    ListNode *right = l2;

    while (left != NULL && right != NULL) {
        int lval = left->val;
        int rval = right->val;
        if (lval < rval) {
            if (left->next == NULL || left->next->val > rval) {
                ListNode *tmp = left;
                left = left->next;
                tmp->next = right;
            } else {
                left = left->next;
            }
        }
        else {
            if (right->next == NULL || right->next->val > lval) { 
                ListNode *tmp = right;
                right = right->next;
                tmp->next = left;
            } else { 
                right = right->next;
            }
        }
    }
    return l1->val < l2->val ? l1 : l2;
}

int main(int argc, char const* argv[])
{
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(5);
    l1->next->next = new ListNode(7);
    l1->next->next->next = new ListNode(8);

    ListNode *l2 = new ListNode(2);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(8);
    l2->next->next->next = new ListNode(20);

    ListNode *merged_list = mergeLists(l1, l2);
    while (merged_list != NULL) {
        std::cout << merged_list->val << std::endl;
        merged_list = merged_list->next;
    }
    return 0;
}
