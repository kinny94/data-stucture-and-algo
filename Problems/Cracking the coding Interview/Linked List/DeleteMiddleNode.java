class DeleteMiddleNode {

    public void deleteMiddlenode(LinkedListNode head) {
        LinkedListNode fastPointer = head;
        LinkedListNode slowPointer = head;

        while (fastPointer.nextNode() != null && fastPointer.nextNode().nextNode() != null) {
            fastPointer = fastPointer.nextNode().nextNode();
            slowPointer = slowPointer.nextNode();
        }

        LinkedListNode next = slowPointer.next;
        slowPointer.data = next.data;
        slowPointer.next = next.nextNode();
    }
}