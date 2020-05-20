class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //find length first
        int len = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            len++;
        }
        // connect as a circle
        iter.next = head;
        
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}