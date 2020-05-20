class ReverseK{
    static LinkedListNode reverseKNodes(LinkedListNode head, int k) {
        
        // if k is 0 or 1, then list is not changed
        if (k <= 1 || head == null) {
            return head;
        }
        
        LinkedListNode reversed = null;
        LinkedListNode prevTail = null;
        
        while (head != null && k > 0) {
            LinkedListNode currentHead = null;
            LinkedListNode currentTail = head;
            
            int n = k;
            while (head != null && n > 0) {
                LinkedListNode temp = head.next;
                head.next = currentHead;
                currentHead = head;
                
                head = temp;
                n--;
            }
            
            if (reversed == null) {
                reversed = currentHead;
            }
            
            if (prevTail != null) {
                prevTail.next = currentHead;
            }
            prevTail = currentTail;
        }
        
        return reversed;
    }
    
    public static void main(String[] args) {
        int[] v1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedListNode listHead = LinkedList.createLinkedList(v1);
        System.out.print("Original list: ");
        LinkedList.display(listHead);
        
        listHead = reverseKNodes(listHead, 4);
        System.out.print("List reversed by 4: ");
        LinkedList.display(listHead);
    }
}  