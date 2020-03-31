class Node {
    
    private int value;
    private Node leftChildNode;
    private Node rightChildNode;
    private int height;

    Node(int value) {
        this.value = value;
        this.rightChildNode = null;
        this.leftChildNode = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public Node getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

class AVLTrees {

    private Node root;

    AVLTrees() {
        this.root = null;
    }

    // insertion
    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.getLeftChildNode()) - getHeight(node.getRightChildNode());
    }

    private Node rightRotation(Node node) {

        /*
             7      will become      5
            /                       / \
           5                       3   7
          /
         3 
        */
        Node tempNode = node.getLeftChildNode();
        Node t =  tempNode.getRightChildNode();

        tempNode.setRightChildNode(node);
        node.setLeftChildNode(t);

        node.setHeight(Math.max(getHeight(node.getLeftChildNode()), getHeight(node.getRightChildNode())) + 1);
        tempNode.setHeight(Math.max(getHeight(tempNode.getLeftChildNode()), getHeight(tempNode.getRightChildNode())) + 1);
        return tempNode;
    }

    private Node leftRotation(Node node) {
        Node tempNode = node.getRightChildNode();
        Node t = tempNode.getLeftChildNode();

        tempNode.setLeftChildNode(node);
        node.setRightChildNode(t);

        node.setHeight(Math.max(getHeight(node.getLeftChildNode()), getHeight(node.getRightChildNode())) + 1);
        tempNode.setHeight(Math.max(getHeight(tempNode.getLeftChildNode()), getHeight(tempNode.getRightChildNode())) + 1);
        return tempNode;
    }

    private Node performInsertionRotations(int data, Node node) {
        int balance = getBalance(node);

        // left left rotation
        if (balance > 1 && data < node.getLeftChildNode().getValue()) {
            return rightRotation(node);
        }

        // right right rotation
        if (balance < -1 && data > node.getRightChildNode().getValue()) {
            return leftRotation(node);
        }

        // left - right rotation
        if (balance > 1 && data > node.getLeftChildNode().getValue()) {
            node.setLeftChildNode(leftRotation(node.getLeftChildNode()));
            return rightRotation(node);
        }

        // right left rotation
        if (balance < -1 && data < node.getRightChildNode().getValue()) {
            node.setRightChildNode(rightRotation(node.getRightChildNode()));
            return leftRotation(node);
        }

        return node;
    }

    public void insert(int data) {
        this.root = insert(data, root);
    }

    private Node insert(int data, Node node) {

        if (node == null) {
            return new Node(data);
        }

        if (data < node.getValue()) {
            // insert in the left sub tree
            node.setLeftChildNode(insert(data, node.getLeftChildNode()));
        } else {
            // insert in the right sub tree
            node.setRightChildNode(insert(data, node.getRightChildNode()));
        }

        node.setHeight(Math.max(getHeight(node.getLeftChildNode()), getHeight(node.getRightChildNode())) + 1);
        node = performInsertionRotations(data, node);
        return node;
    }

    // traversal
    public void traversal() {

        if (root == null) {
            return;
        }

        inOrderTraversal(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {

        if (node.getLeftChildNode() != null) {
            inOrderTraversal(node.getLeftChildNode());
        }

        System.out.print(node.getValue() + " -> ");

        if (node.getRightChildNode() != null) {
            inOrderTraversal(node.getRightChildNode());
        }
    }

    private void preOrderTraversal(Node node) {
        System.out.print(node.getValue() + " -> ");

        if (node.getLeftChildNode() != null) {
            preOrderTraversal(node.getLeftChildNode());
        }

        if (node.getRightChildNode() != null) {
            preOrderTraversal(node.getRightChildNode());
        }
    }

    private void postOrderTraversal(Node node) {
        if (node.getLeftChildNode() != null) {
            postOrderTraversal(node.getLeftChildNode());
        }

        if (node.getRightChildNode() != null) {
            postOrderTraversal(node.getRightChildNode());
        }

        System.out.print(node.getValue() + " -> ");
    }

    // deletion
    private Node getPredecessor(Node node) {
        Node predecessor = node;
        while (predecessor.getRightChildNode() != null) {
            predecessor = predecessor.getRightChildNode();
        }

        return predecessor;
    }

    private Node performDeletionRotations(Node node) {
        int balance = getBalance(node);

        if (balance > 1) {
            // if the tree is left heavy - left rotation on parent  and right rotation on grandparent
            if (getBalance(node.getLeftChildNode()) < 0) {
                node.setLeftChildNode(leftRotation(node.getLeftChildNode()));
            }

            return rightRotation(node);
        }

        if (balance < -1) {
            // if the tree is right heavy - right rotation on parent and left on grandparent 
            if (getBalance(node.getRightChildNode()) > 0) {
                node.setRightChildNode(rightRotation(node.getRightChildNode()));
            }

            return leftRotation(node);
        }

        return node;
    }

    private Node delete(int data, Node node) {
        if (node == null) {
            return node;
        }

        if (data < node.getValue()) {
            node.setLeftChildNode(delete(data, node.getLeftChildNode()));
        } else if (data > node.getValue()) {
            node.setRightChildNode(delete(data, node.getRightChildNode()));
        } else {
            if (node.getLeftChildNode() == null && node.getRightChildNode() == null) {
                // remove the leaf node
                return null;
            }

            if (node.getLeftChildNode() == null) {
                Node tempNode = node.getRightChildNode();
                node = null;
                return tempNode;
            } else  if (node.getRightChildNode() == null) {
                Node tempNode = node.getLeftChildNode();
                node = null;
                return tempNode;
            }

            Node tempNode = getPredecessor(node.getLeftChildNode());
            node.setValue(tempNode.getValue());
            node.setLeftChildNode(delete(tempNode.getValue(), node.getLeftChildNode()));
        }

        node.setHeight(Math.max(getHeight(node.getLeftChildNode()), getHeight(node.getRightChildNode())) + 1);
        return performDeletionRotations(node);
    }

    public void delete(int data) {
        root = delete(data, root);
    }

    public static void main(String[] args) {
        AVLTrees tree = new AVLTrees();
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        tree.insert(30);

        tree.traversal();

        tree.delete(10);
        tree.traversal();
    }
}