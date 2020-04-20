/*
    1. Create two pointers. one fast and one slow
    2. Move fast pointer at a rate of 2 and slow at a rate of 1
    3. When they collide, moves slow pointer to the head of the linked list and fast pointer at the rate of 1;
    4. Move slow pointer and faast pointer at the rate of one step. Return the new collision point
*/
class LoopDetection {
    public boolean isLoopPresent(LinkedListNode node) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}