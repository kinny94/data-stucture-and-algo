class InorderSuccessor{
    static BinaryTreeNode findMinInTree(
    BinaryTreeNode root) {
        
        if(root == null)
        return null;
        
        while(root.left != null) {
            root = root.left;
        }
        
        return root;
    }
    
    static BinaryTreeNode inorderSuccessorBstParentPointer(
    BinaryTreeNode node){
        
        if(node == null) {
            return null;
        }
        
        if(node.right != null)
        {
            return findMinInTree(node.right);
        }
        
        while(node.parent != null)
        {
            if(node.parent.left == node){
                return node.parent;
            }
            node = node.parent;
        }
        
        return null;
    }
    
    static BinaryTreeNode findSuccessor(
    BinaryTreeNode root, int d) {
        while (root != null) {
            
            if(root.data < d) {
                root = root.right;
            } else if(root.data > d) {
                root = root.left;
            } else {
                return inorderSuccessorBstParentPointer(root);
            }
        }
        return null;
    }
    /// Test Program.
    public static void main(String[] args) {
        
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
        BinaryTreeNode root = BinaryTree.createBST(input);
        
        BinaryTree.populate_parents(root);
        
        for (Integer d : input) {
            BinaryTreeNode successor = findSuccessor(root, d);
            int i = input.indexOf(d);
            Integer expected_val = null;
            if (i < input.size() - 1) {
                expected_val = input.get(i + 1);
            }
            if (successor != null)
            System.out.print("(" + d + ", " + successor.data + ") ");
            else 
            System.out.print("(" + d + ", null) ");
        }
    }
}  