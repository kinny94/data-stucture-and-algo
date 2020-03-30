class Node {

    private int value;
    private Node nextNode;

    Node(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class LinkedList {
    
    public Node root;

    LinkedList() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int value) {

        Node node = new Node(value);
        node.setNextNode(null);
        
        if (this.isEmpty()) {
            this.root = node;
        } else {
            Node currentNode = root;
            while (currentNode != null) {
                if (currentNode.getNextNode() == null) {
                    currentNode.setNextNode(node);
                    return;
                }
                currentNode = currentNode.getNextNode();
            }
        }
    }

    public void display() {
        Node currentNode = root;
        while(currentNode != null) {
            System.out.print(currentNode.getValue() + " -> ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    public int delete(int value) {

        if (this.root == null) {
            System.out.println("Element not found!");
        }

        if (this.root.getValue() == value) {
            System.out.println("Element found at root!");
            this.root = root.getNextNode();
        }

        Node currentNode = root;
        while(currentNode.getNextNode() != null) {
            
            if (currentNode.getNextNode().getValue() == value) {
                Node removedNode = currentNode.getNextNode();
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                return removedNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        } 

        System.out.println("Element not found!");
        return -1;
    }

    public void find(int value) {
        Node currentNode = root;
        while(currentNode != null) {
            if (currentNode.getValue() == value) {
                System.out.println("Element found!");
                return;
            } 
            currentNode = currentNode.getNextNode();
        }
        System.out.println("Element not found!");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(5);
        ll.insert(10);
        ll.insert(15);
        ll.insert(20);
        ll.insert(25);

        ll.display();

        ll.find(5);

        ll.delete(5);
        ll.display();

        ll.delete(25);
        ll.display();

        ll.insert(35);
        ll.display();

        ll.delete(15);
        ll.display();

        ll.find(10);
        ll.find(15);
        ll.find(35);
    }
}

