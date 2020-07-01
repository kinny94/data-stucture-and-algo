class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i=0; i<n; i++) {
            if (p1.next == null) {
                return head.next;
            }

            p1 = p1.next;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return head;
    }
}