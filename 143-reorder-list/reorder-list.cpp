class Solution {
public:
    void reorderList(ListNode* head) {
        if (!head || !head->next) return;

    vector<ListNode*> List;
    for (ListNode* node = head; node; node = node->next) {
        List.push_back(node);
    }

    int Start = 1;                    // 🔥 FIX
    int End = List.size() - 1;
    ListNode* Curr = head;

    while (Start <= End) {
        Curr->next = List[End];
        Curr = Curr->next;
        End--;

        if (Start > End) break;

        Curr->next = List[Start];
        Curr = Curr->next;
        Start++;
    }

    Curr->next = nullptr;             // 🔥 IMPORTANT
    }
};