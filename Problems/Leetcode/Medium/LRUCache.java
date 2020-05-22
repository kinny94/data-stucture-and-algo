class Node {
    int val;
    int key;
    Node next;
    Node prev;
}

class LRUCache {
    
    private final Node head = new Node();
    private final Node tail = new Node();
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            
            map.put(key, newNode);
            add(newNode);
        }
    }
    
    public void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        
        next.prev = prev;
        prev.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */