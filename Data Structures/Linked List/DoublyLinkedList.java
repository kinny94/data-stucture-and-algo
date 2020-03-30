class Node {

    private int value;
    private Node nextNode;
    private Node prevNode;

    public Node(int value) {
        this.value = value;
        this.prevNode = null;
        this.nextNode = null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setPrevNode(Node node) {
        this.prevNode = node;
    }

    public Node getPrevNode() {
        return this.prevNode;
    }
}

class DoublyLinkedList {
    
    Node root;

    DoublyLinkedList() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }


    public void insertAfter(int after, int value) {
        Node newNode = new Node(value);
        Node currentNode = root;
        
        while(currentNode != null) {
            if (currentNode.getValue() == after) {
                Node currentNodeNextNode = currentNode.getNextNode();
                currentNodeNextNode.setPrevNode(newNode);
                currentNode.setNextNode(newNode);
                newNode.setPrevNode(currentNode);
                newNode.setNextNode(currentNodeNextNode);
                return;
            }
            currentNode = currentNode.getNextNode();
        }

        System.out.println("Element does not exist!!");
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (this.isEmpty()) {
            this.root = newNode;
            return;
        } else {
            Node currentNode = root;
            while(currentNode != null) {
                if (currentNode.getNextNode() == null) {
                    currentNode.setNextNode(newNode);
                    newNode.setPrevNode(currentNode);
                    newNode.setNextNode(null);
                    return;
                }
                currentNode = currentNode.getNextNode();
            }
        }
    }

    public void display() {
        Node currentNode = this.root;
        while (currentNode != null) {
            System.out.print(currentNode.getValue() +  " -> ");
            currentNode = currentNode.getNextNode();
        }

        System.out.println();
    }

    public int delete(int value) {

        if (isEmpty()) {
            System.out.println("List is empty");
            return -1;
        }


        Node currentNode = root;

        if (this.root.getValue() == value) {
            this.root = currentNode.getNextNode();
            this.root.setPrevNode(null);
            return value;
        }

        while(currentNode != null) {
            if (currentNode.getValue() == value) {

                if (currentNode.getNextNode() == null) {
                    currentNode.getPrevNode().setNextNode(null);
                    return value;
                } else {
                    Node nextNode = currentNode.getNextNode();
                    currentNode.getPrevNode().setNextNode(nextNode);
                    nextNode.setPrevNode(currentNode.getPrevNode());
                    return value;
                }
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
        }
        System.out.println("Element not found!");
    }


    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insert(5);
        dl.insert(10);
        dl.insert(20);
        dl.insert(25);
        dl.insert(30);

        dl.display();

        dl.insertAfter(10, 15);
        dl.display();

        dl.delete(10);
        dl.display();

        dl.delete(30);
        dl.display();
    }
}