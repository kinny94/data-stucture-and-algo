class ListNode {
    int value = 0;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
    }
}

class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
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
            if (head.value != headSecondHalf.value) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromeLinkedList.isPalindrome(head));
    
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromeLinkedList.isPalindrome(head));
    }
}