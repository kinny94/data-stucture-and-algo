class ReverseALinkedList {
    public static <T> void reverse(SinglyLinkedList<T> list){
        SinglyLinkedList<T>.Node prev = null; //To keep track of the previous element, will be used in swapping links
				SinglyLinkedList<T>.Node current = list.headNode; //firstElement
				SinglyLinkedList<T>.Node next = null;

				//While Traversing the list, swap links
				while (current != null) {
					next = current.nextNode;
					current.nextNode = prev;
					prev = current;
					current = next;
				}
				//Linking Head Node with the new First Element
				list.headNode = prev;
    }
}