class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode headSecondHalf = reverse(slow);
        ListNode copySecondHalf = headSecondHalf;
        
        while (head != null && headSecondHalf != null) {
            if (head.val != headSecondHalf.val) {
                break;
            }
            
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }
        
        reverse(copySecondHalf);
        if (head == null || headSecondHalf == null) {
            return true;
        } 
        
        return false;
    }
    
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}