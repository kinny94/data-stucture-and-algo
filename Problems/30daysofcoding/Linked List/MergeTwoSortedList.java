class MergeTwoSortedList {
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1 == null && l2 == null) return null;

        ListNode dummy = new ListNode();
        ListNode currentNode = dummy;

        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }

            currentNode = currentNode.next;
        }

        currentNode.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}