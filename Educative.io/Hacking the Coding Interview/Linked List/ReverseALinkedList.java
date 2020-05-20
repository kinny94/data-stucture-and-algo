class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}    

class ReverseALinkedList {
    public static reverseALinkedList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
}