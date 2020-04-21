class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
  
        Map<Node, Node> map = new HashMap<>();
           
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
           
        temp = head;
           
        while(temp != null) {
              map.get(temp).next = map.get(temp.next);
              map.get(temp).random = map.get(temp.random);
              temp = temp.next;
        }
        return map.get(head);
     }
}