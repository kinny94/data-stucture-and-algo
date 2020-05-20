class DeleteAllOccurence {
    public static LinkedListNode deleteNode(LinkedListNode head, int key) 
    {
      LinkedListNode prev = null;
      LinkedListNode current = head;
  
      while (current != null) {
        if (current.data == key) {   
            if(current == head){
                head = head.next;
                current = head;
              }
          else{
              prev.next = current.next;
              current = current.next;
            }
        }
        else {
            prev = current;
            current = current.next;
        }
      }
  
      // key not found in list
      if (current == null) {
        return head;
      }
  
      return head;
    }
    public static void main(String[] args) {
      LinkedListNode listHead = null;
      int[] list1 = {20, 14,36, 11, 72, 41};
      listHead = LinkedList.createLinkedList(list1);
      System.out.print("Original: ");
      LinkedList.display(listHead);
  
      listHead = deleteNode(listHead, 72);
      System.out.printf("After deleting 72 from list: ");
      LinkedList.display(listHead);
    }
  }  