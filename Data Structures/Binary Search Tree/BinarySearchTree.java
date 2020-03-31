class Node {
    
    private int value;
    private Node leftChild;
    private Node rightChild;

    Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}

class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            this.root = new Node(value);
        } else {
            insertNode(value, root);
        }
    }

    private void insertNode(int value, Node node) {
        if (node.getValue() > value) {
            // node is gonna be the left child
            if (node.getLeftChild() != null) {
                insertNode(value, node.getLeftChild());
            } else {
                node.setLeftChild(new Node(value));
            }
        } else {
            // node is gonna be the right child
            if (node.getRightChild() != null) {
                insertNode(value, node.getRightChild());
            } else {
                node.setRightChild(new Node(value));
            }
        }
    }

    // traversal
    public void traversal() {

        this.inOrderTraversal(this.root);
        System.out.println();
        
        this.preOrderTraversal(this.root);
        System.out.println();

        this.postOrderTraversal(this.root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node.getValue() + " -> ");

        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    private void preOrderTraversal(Node node) {
        System.out.print(node.getValue() + " -> ");

        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    private void postOrderTraversal(Node node) {
        if (node.getLeftChild() != null) {
            postOrderTraversal(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            postOrderTraversal(node.getRightChild());
        }

        System.out.print(node.getValue() + " -> ");
    }

    // get minimum and maximum in a tree
    public int getMinValue() {
        if (this.root == null) {
            return -1;
        }

        return getMin(this.root);
    }

    public int getMaxValue() {
        if (this.root == null) {
            return -1;
        }

        return getMax(this.root);
    }

    private int getMin(Node node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }

        return node.getValue();
    }

    private int getMax(Node node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getValue();
    }

    public void delete(int value) {
        if (this.root != null) {
            this.root = deleteNode(value, root);
        }
    }

    private Node deleteNode(int value, Node node) {

        if (node == null) {
            return node;
        }

        if (node.getValue() > value) {
            node.setLeftChild(deleteNode(value, node.getLeftChild()));
        } else if (node.getValue() < value){
            node.setRightChild(deleteNode(value, node.getRightChild()));
        } else {
            // we found the node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Leaf node removed!");
                return null;
            }

            // if the given node has a single left or right child
            if (node.getLeftChild() == null) {
                System.out.println("Removing the right child!!");
                Node returnNode = node.getRightChild();
                node.setLeftChild(null);
                return returnNode;
            } else if (node.getRightChild() == null) {
                System.out.println("Removing the left child!");
                Node returnNode = node.getLeftChild();
                node.getRightChild();
                return returnNode;
            }

            // the node has both the left child and the right child
            System.out.println("Removing the node with both the left child and the right child!");
            Node tempNode = this.getPredecessorNode(node.getLeftChild());
            
            // swap the two nodes
            node.setValue(tempNode.getValue());
            node.setLeftChild(deleteNode(value, node.getLeftChild()));
        }

        return node;

    }

    private Node getPredecessorNode(Node node) {
        if (node.getRightChild() != null) {
            getPredecessorNode(node.getRightChild());
        }

        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(20);
        bst.insert(10);
        bst.insert(15);
        bst.insert(25);
        bst.insert(23);
        bst.insert(39);
        bst.insert(35);
        bst.insert(42);

        bst.traversal();
        System.out.println();

        System.out.println(bst.getMaxValue());
        System.out.println(bst.getMinValue());

        System.out.println();
        bst.delete(10);
        bst.traversal();
    }
}