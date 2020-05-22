class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StacksUsingLinkedList {
    
    private Node top;

    StacksUsingLinkedList() {
        this.top = null;
    }

    public void push(int x) {
        Node oldTop = top;
        top = new Node(x);
        top.next = oldTop;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Empty stack");
        }

        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top == null ? true : false;
    }
}