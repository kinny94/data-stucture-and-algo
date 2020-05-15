class IntersectionOfALinkedList {
    
    
    public ListNode getIntersectionOfAList(ListNode headA, ListNode headB) {
    
        if (headA == null || headB == null) { 
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = b == null ? headB : a.next;
            b = a == null ? headA : b.next;
        }

        return a;
    }
}