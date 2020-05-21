class IdenticalTrees{
    public static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
        
        if (root1 == null && root2 == null) {
            return true;
        }
        
        if (root1 != null && root2 != null) {
            return ((root1.data == root2.data) &&
            areIdentical(root1.left, root2.left) &&
            areIdentical(root1.right, root2.right));
        }
        
        return false;
    }
    
    public static void main(String[] argv) {
        
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);input1.add(50);input1.add(200);input1.add(25);input1.add(125);input1.add(250);
        BinaryTreeNode root1  = BinaryTree.createBST(input1);
        
        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(1);input2.add(2);input2.add(10);input2.add(50);input2.add(180);input2.add(199);
        BinaryTreeNode root2  = BinaryTree.createBST(input2);
        
        BinaryTree.displayLevelOrder(root1);
        
        BinaryTree.displayLevelOrder(root2);
        
        if (areIdentical(root1, root2)) {
            System.out.println("The trees are identical");
        } else {
            System.out.println("The trees are not identical");
        }
    }
}  