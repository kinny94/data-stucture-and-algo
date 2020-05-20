class MergeSort{
    // this method splits linked list in two halves by iterating over whole list
    // It returns head pointers of first and 2nd halves of linked lists in firstSecond
    // Head of 1st half is just the head node of linked list
    public static void splitInHalf(LinkedListNode head,
    Pair<LinkedListNode,LinkedListNode> firstSecond) {
        
        if (head == null) {
            return;
        }
        
        // Only one element in the list.
        if (head.next == null) {
            
            firstSecond.first = head;
            firstSecond.second = null;
        }
        else {
            
            // Let's use the classic technique of moving two pointers:
            // 'fast' and 'slow'. 'fast' will move two steps in each 
            // iteration where 'slow' will be pointing to middle element
            // at the end of loop.
            
            LinkedListNode slow, fast;
            slow = head;
            fast = head.next;
            
            while (fast != null) {
                
                fast = fast.next;
                
                if (fast != null) {
                    
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            
            firstSecond.first = head;
            firstSecond.second = slow.next;
            
            // Terminate first linked list.
            slow.next = null;
        }
    }
    
    public static LinkedListNode mergreSortedLists(LinkedListNode first,
    LinkedListNode second) {
        
        if (first == null) {
            return second;
        }
        else if (second == null) {
            return first;
        }
        
        LinkedListNode newHead;
        if (first.data <= second.data) {
            newHead = first;
            first = first.next;
        }
        else {
            newHead = second;
            second = second.next;
        }
        
        LinkedListNode newCurrent = newHead;
        while (first != null && second != null) {
            LinkedListNode temp = null;
            if (first.data <= second.data) {
                temp = first;
                first = first.next;
            } else {
                temp = second;
                second = second.next;
            }
            
            newCurrent.next = temp;
            newCurrent = temp;
        }
        
        if (first != null) {
            newCurrent.next = first;
        } else if (second != null) {
            newCurrent.next = second;
        }
        
        return newHead;
    }
    
    public static LinkedListNode mergeSort(LinkedListNode head) {
        
        // No need to sort a single element.
        if (head == null || head.next == null) {
            return head;
        }
        
        Pair<LinkedListNode,LinkedListNode> firstSecond = 
        new Pair<LinkedListNode,LinkedListNode>(null,null);
        
        // Let's split the list in half, sort the sublists
        // and then merge the sorted lists.
        splitInHalf(head, firstSecond);
        
        firstSecond.first = mergeSort(firstSecond.first);
        firstSecond.second = mergeSort(firstSecond.second);
        
        return mergreSortedLists(firstSecond.first, firstSecond.second);
    }
    
    public static void main(String[] args) {
        
        int[] v1 = {29, 23, 82, 11, 4, 3, 21};
        LinkedListNode listHead1 = LinkedList.createLinkedList(v1);
        
        System.out.print("Unsorted list: ");
        LinkedList.display(listHead1);
        
        listHead1 = mergeSort(listHead1);
        System.out.print("Sorted list: ");
        LinkedList.display(listHead1);
    }
}