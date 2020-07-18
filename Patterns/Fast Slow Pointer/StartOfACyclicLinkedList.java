class ListNode {
    int value = 0;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
    }
}

class StartOfACyclicLinkedList {
    public static ListNode findCycleStart(ListNode head) {
        int cyclicLength = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cyclicLength = calculateCycleLength(slow);
                break;
            }
        }
    
        return findStart(head, cyclicLength);
    }

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while(current != slow);


        return cycleLength;
    }

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;                       
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
    
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + StartOfACyclicLinkedList.findCycleStart(head).value);
    
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + StartOfACyclicLinkedList.findCycleStart(head).value);
    
        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + StartOfACyclicLinkedList.findCycleStart(head).value);
    }
}