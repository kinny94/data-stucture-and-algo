class DetectCycle {
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
		
        SinglyLinkedList.Node slow = list.headNode;
        SinglyLinkedList.Node fast = list.headNode;
         
        while(slow != null && fast != null && fast.nextNode != null)
        {	
            slow = slow.nextNode;	//the slow pointer will jump 1 step
            fast = fast.nextNode.nextNode; //the fasr pointer will jump 2 steps 
			// when the pointers become equal then there must be a loop
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}