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

    public int findKthMax(Node root, int k) {
        StringBuilder result = new StringBuilder();
        result = inOrder(root, result);

        String[] array = result.toString().split(",");
        if ((array.length - k) >= 0 ) {
            return Integer.parseInt(array[array.length - k]);
        }
        return -1;
    }

    public StringBuilder inOrder(Node root, StringBuilder result) {
        if (root.getLeftChild() != null) {
            inOrder(root.getLeftChild(), result);
        }

        result.append(root.getData() + ",");
        
        if (root.getRightChild() != null) {
            inOrder(root.getRightChild(), result);
        }

        return result;
    } 
}