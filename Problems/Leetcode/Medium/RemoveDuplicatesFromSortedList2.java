class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode node = head;

        while(node != null) {
            if (node.next != null && node.val == node.next.val) {
                int duplicatedValue = node.val;
                while(node != null && node.val == duplicatedValue) {
                    node = node.next;
                }
            } else {
                current.next = node;
                current = current.next;
                node = node.next;
            }
        }

        current.next = null;

        return dummy.next;
    }    
}