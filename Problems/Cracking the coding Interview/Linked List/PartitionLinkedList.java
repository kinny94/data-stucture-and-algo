class PartitionLinkedList {
    public void partitionLinkedList(LinkedListNode node, int ele) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node != null) {
            LinkedListNode next = n.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }

            node = next;
        }

        tail.next = null;

        return head;
    }
}