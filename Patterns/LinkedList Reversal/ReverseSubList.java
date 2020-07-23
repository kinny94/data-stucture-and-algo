class ListNode {
    int value = 0;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
    }
}

class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        for (int i=0; current != null && i< p - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstHalf = previous;
        ListNode lastNodeOfSubList = current;
        ListNode next = null;

        for (int i=0; current != null && i < q-p+1; i++) {
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
    
        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
          System.out.print(result.value + " ");
          result = result.next;
        }
    }
}