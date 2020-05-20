class Solution {
    
    public ListNode reverseLinkedList(ListNode head, ListNode end) {        
        ListNode new_head = null, curr = head;
        while(curr != end) {
            ListNode next_node = curr.next;
            curr.next = new_head;
            new_head = curr;
            curr = next_node;            
        }
        return new_head;
    }
            
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, ktail = null, new_head = null;
        while(curr != null) {
            int count = 0;
            while(count < k && curr != null) {
                curr = curr.next;
                count += 1;
            }
            if(count == k) {
                ListNode revHead = this.reverseLinkedList(head, curr);
                if(new_head == null){
                    new_head = revHead;                    
                }
                if(ktail != null){
                    ktail.next = revHead;                    
                }
                ktail = head; 
                head = curr;
            }
        }
        if(ktail != null){
            ktail.next = head;            
        }
        return new_head;
    }
}