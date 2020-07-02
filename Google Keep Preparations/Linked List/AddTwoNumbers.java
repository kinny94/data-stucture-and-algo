class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode currentNode = dummy;
        int carry = 0;

        while(l1 != null || l2 != null | carry != 0) {

            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            currentNode.next = new ListNode(carry % 10);
            carry = carry / 10;
            currentNode = currentNode.next;
        }

        return dummy.next;

    }
}