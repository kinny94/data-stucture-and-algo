class Node {
    Node leftChild;
    Node rightChild;
    int val;


    Node(int val) {
        this.rightChild = null;
        this.leftChild = null;
        this.val = val;
    } 

    public int getValue() {
        return this.val;
    }

    public void setValue(int value) {
        this.val = val;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node node) {
        this.leftChild = node;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setLeftChild(Node node) {
        this.leftChild = node;
    }

    @Override
    public String toString() {
        return val + "";
    }
    
}

class TreeTraversal {

    public void traversal() {

    }

    inOrderTraversal(Node node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node.getValue() + " -> ");

        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    preOrderTraversal(Node node) {
        System.out.print(node.getValue() + " -> ");

        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    postOrderTraversal(Node node) {
        if (node.getLeftChild() != null) {
            postOrderTraversal(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            postOrderTraversal(node.getRightChild());
        }

        System.out.print(node.getValue() + " -> ");
    }
}