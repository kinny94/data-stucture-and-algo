class InorderIterator {
    // TODO: Write - Your - Code
    public InorderIterator(BinaryTreeNode root) {
        if (root.left != null) {
            InorderIterator(root.left);
        }
        
        System.out.println(root.val);
        
        if (root.right != null) {
            InorderIterator(root.right);
        }
    }
    
    public boolean hasNext() {
        return false;
    }
    
    public BinaryTreeNode getNext() {
        return null;
    }
    
    //Don't Change anything down below
    public String inorderUsingIterator(BinaryTreeNode root) {
        InorderIterator iter = new InorderIterator(root);
        String result = "";
        while (iter.hasNext()) {
            result += iter.getNext().data + " ";
        }
        return result;
    }   
}