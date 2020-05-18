class HeightOfABinaryTree {
    public static int findHeight(Node root) {
        if (root== null) return -1;
        return 1 + Math.max(findHeight(root.getLeftChild()), findHeight(root.getRightChild()));
    }  
}