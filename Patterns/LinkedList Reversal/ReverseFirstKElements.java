class ListNode {
    int value = 0;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
    }
}


class ReverseFirstKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (k == 1) {
            return head; 
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        ListNode lastNodeOfFirstHalf = previous;
        ListNode lastNodeOfSubList = current;

        for (int i = 0; current != null && i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (lastNodeOfFirstHalf != null) {
            lastNodeOfFirstHalf.next = previous;
        } else {
            head = previous;
        }

        lastNodeOfSubList.next = current;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseFirstKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
        System.out.print(result.value + " ");
        result = result.next;
        }
    }
}