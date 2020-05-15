class CheckUnionIntersection {
    //performs union of two lists
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        //if one of the list is empty then return the other list
        if (list1.isEmpty())
            return list2;
        if (list2.isEmpty())
            return list1;
        //take the head of the first list
        SinglyLinkedList<T>.Node last = list1.getHeadNode();
        //traverse it to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //attach the last element of list1 to head of list2
        last.nextNode = list2.getHeadNode();
        //remove duplicates that might have been added now
        list1.removeDuplicatesWithHashing(); //complexity of this function is O(n)
        return list1;
    }
    // helper function which checks if the element is present in the list
    public static <T> boolean contains(SinglyLinkedList<T> list, T data) {
        SinglyLinkedList<T>.Node current = list.getHeadNode();
        //traverses the whole list
        while (current != null) {
            //returns true if found
            if (current.data.equals(data))
                return true;
            current = current.nextNode;
        }
        //returns false if not found
        return false;
    }
    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        //returns empty list if either one of the lists is empty
        if (list1.isEmpty() || list2.isEmpty())
            return result;
  
        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        //traverses list1 and checks if each element is present in list2
        while (current != null) {
            if (contains(list2, current.data)) {
                //inserts in result if it is present in both
                result.insertAtHead(current.data);
            }
            current = current.nextNode;
        }

        return result;
    }
}