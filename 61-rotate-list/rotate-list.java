
class Solution {
    public int length(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0)return head;

        int  n = length(head);
        
        k %= n;
        if(k == 0) return head;

        ListNode s = head;
        ListNode f = head;

        for(int i=1; i<=k+1; i++){
            f = f.next;
        }
        while(f != null){
            f = f.next;
            s = s.next;
        }
        ListNode a = s.next;
        s.next = null;
        ListNode t = a;
        while(t.next != null){
            t = t.next;
        }
        t.next = head;
        return a;
    }
    
}