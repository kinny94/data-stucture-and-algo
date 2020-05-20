class AddIntegers{
    static LinkedListNode addIntegers(LinkedListNode integer1, LinkedListNode integer2) {
    
      LinkedListNode result = null;
      LinkedListNode last = null;
      int carry = 0;
  
      while (integer1 != null || integer2 != null || carry > 0) {
      
        int first = (integer1 == null ? 0 : integer1.data);
        int second = (integer2 == null ? 0 : integer2.data);
        int sum = first + second + carry;
        LinkedListNode pNew = new LinkedListNode(sum % 10);
  
        carry = sum / 10;
        if (result == null) {
          result = pNew;
        } else {
          last.next = pNew;
        }
  
        last = pNew;
        if (integer1 != null) {
          integer1 = integer1.next;
        }
        if (integer2 != null) {
          integer2 = integer2.next;
        }
      }
      return result;
    }
    
    public static void main(String[] args) {
  
      int[] v1 = new int[]{9, 9, 0, 1}; // 1099
      int[] v2 = new int[]{2, 3, 7}; // 732
    
      LinkedListNode first = LinkedList.createLinkedList(v1);
      LinkedListNode second = LinkedList.createLinkedList(v2);
  
      LinkedListNode result = addIntegers(first, second);
  
      System.out.printf("First integer: ");
      LinkedList.display(first);
      System.out.printf("Second integer: ");
      LinkedList.display(second);
      
      System.out.printf("Result: ");
      LinkedList.display(result);
    }
  }  