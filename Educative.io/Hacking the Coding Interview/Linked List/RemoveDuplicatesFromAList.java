class RemoveDuplicate{
    public static LinkedListNode removeDuplicates(LinkedListNode head) 
    {
      if (head == null) {
        return head;
      }
  
      HashSet<Integer> dupSet = new HashSet<Integer>();
      LinkedListNode curr = head;
      dupSet.add(curr.data);
  
      while (curr.next != null) {
        if (!dupSet.contains(curr.next.data)) {
          // Element not found in map, let's add it.
          dupSet.add(curr.next.data);
          curr = curr.next;
        } 
        else {
          // Duplicate node found. Let's remove it from the list.
          curr.next = curr.next.next;
        }
      }
      return head;
    }
    public static void main(String[] args) {
        int[] list1 = {4, 7, 4, 9, 7, 11, 4};
        int[] list1Expected = {4, 7, 9, 11};
        
        LinkedListNode listHead1 = LinkedList.createLinkedList(list1);
        LinkedListNode listHead1_expected = LinkedList.createLinkedList(list1Expected);
        
        System.out.print("Original: ");
        LinkedList.display(listHead1);
        listHead1 = removeDuplicates(listHead1);
        
        System.out.print("After removing duplicates: ");
        LinkedList.display(listHead1);
    }
  }  