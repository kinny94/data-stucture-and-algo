class MirrorBT{
    public static void mirrorBinaryTree(
    BinaryTreeNode root) {
        
        if (root == null) {
            return;
        }
        
        // We will do a post-order traversal of the binary tree.
        
        if (root.left != null) {
            mirrorBinaryTree(root.left);
        }
        
        if (root.right != null) {
            mirrorBinaryTree(root.right);
        }
        
        // Let's swap the left and right nodes at current level.
        
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    
    public static void main(String[] argv) {
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(20);input1.add(50);input1.add(200);input1.add(75);input1.add(25);input1.add(300);
        BinaryTreeNode root  = BinaryTree.createBST(input1);
        BinaryTree.displayLevelOrder(root);
        System.out.println();
        
        mirrorBinaryTree(root);
        System.out.println("Mirrored Tree:");
        BinaryTree.displayLevelOrder(root);  
    }
}  