class Node {

    //Variables
    private int data;
    Node leftChild;
    Node rightChild;

    //Constructor
    Node(int value) {
        this.data = value;
        leftChild = null;
        rightChild = null;
    }

    //Getter-Setter
    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int value) {
        this.data = value;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }
}

class FindKthMaximumValueInBST {

    static int counter;

    public static int findKthMax(Node root, int k) {
        counter = 0;
        Node node = findKthMiaximum(root, k);
        if (node != null) {
            return node.getData();
        }

        return -1;
    }

    public static Node findKthMiaximum(Node node, int k) {
        if (node == null) {
            return null;
        }

        Node newNode = findKthMiaximum(node.getRightChild(), k);

        if (counter != k) {
            counter++;
            newNode = node;
        }

        if (counter == k) {
            return node;
        } else {
            return findKthMiaximum(node.getLeftChild(), k);
        }
    }
}