/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return head;
        ListNode fast=head;
        ListNode slow=head;
        boolean cycle=false;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
            {
                cycle=true;
                break;
            }
        }
        fast=head;
        if(cycle==false) return null;
        else
        {
            while(fast!=slow)
            {
                fast=fast.next;
                slow=slow.next;
            }
        }
        return fast;
    }
}