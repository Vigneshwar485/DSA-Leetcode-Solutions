/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        if (node == nullptr || node->next == nullptr)
            return;

        ListNode* p2 = node->next;
        node->val = p2->val;
        node->next = p2->next;
        delete (p2);
    }
};