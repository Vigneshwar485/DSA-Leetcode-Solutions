/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(head==nullptr||head->next==nullptr){
            return head;
        }
        ListNode* odd=head;
        ListNode* even=head->next;
        ListNode* evenprev=head->next;
        while(even&&even->next!=nullptr){
            odd->next=odd->next->next;
            odd=odd->next;
            even->next=even->next->next;
            even=even->next;
        };
        if(even==nullptr){
            odd->next=evenprev;
        }
        else{
            even->next=nullptr;
            odd->next=evenprev;
        }
        return head;

    }
};