class ListNode {
    int value = 0;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
    }
}

class StartOfACyclicLinkedList {
    public static ListNode findCycleStart(ListNode head) {
        if(head==null) return head;
        ListNode fast=head;
        ListNode slow=head;
        boolean cycle=false;
        while(fast.next!=null && fast.next.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
            {
                cycle=true;
                break;
            }
        }

        fast=head;
        if (cycle==false) { 
            return null;
        } else {
            while(fast!=slow) {
                fast=fast.next;
                slow=slow.next;
            }
        }
        return fast;
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