class FindMiddle {
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        //if list is empty, then return null
        if (list.isEmpty())
          return null;
        
        //both nodes start from the head
        SinglyLinkedList.Node slow = list.headNode;
        SinglyLinkedList.Node fast = list.headNode;
        
        while(slow != null && fast != null && fast.nextNode != null)
        {
            //fast jumps 2 nodes on each iteration
            fast = fast.nextNode.nextNode;
            //if fast is not null (end of list is not reached)
            if(fast != null){
                //then slow jumps 1 node
                //slow is always halfway behind fast
                slow = slow.nextNode;
            }
        }
        return slow.data;
      }    
}