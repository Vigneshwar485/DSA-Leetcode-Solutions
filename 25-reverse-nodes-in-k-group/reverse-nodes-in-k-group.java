/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;

        while(temp!=null) {
            cnt++;

            if(cnt == k) break;

            temp = temp.next;
        }

        return temp;
    }

    private ListNode reverse(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode nextNode = head.next;
        ListNode newHead = reverse(nextNode);
        nextNode.next = head;
        head.next = null;

        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                    break;
                }
            }

            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            if(temp == head) {
                head = kthNode;
            }
            else {
                prevNode.next = kthNode;
                temp.next = nextNode;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }
}