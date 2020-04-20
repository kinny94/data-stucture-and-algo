class ListIntersection {
    
    public LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        LinkedListNode a = headA;
        LinkedListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
}