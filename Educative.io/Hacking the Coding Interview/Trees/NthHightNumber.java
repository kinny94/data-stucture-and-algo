class NthHighest{
    public static int currentCount = 0;
    
    public static BinaryTreeNode findNthHighestInBST(
    BinaryTreeNode node,
    int n) {
        
        if (node == null) {
            return null;
        }
        
        BinaryTreeNode result = 
        findNthHighestInBST(node.right, n);
        
        if(result != null) {
            return result;
        } 
        
        currentCount++;
        if(n == currentCount) {
            return node;
        }
        
        result =
        findNthHighestInBST(node.left, n);
        
        if(result != null) {
            return result;
        } 
        
        return null;
    }
    
    public static void main(String[] argv) {
        
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.count = 7;
        
        BinaryTree.insert(root, 12);
        BinaryTreeNode node12 = BinaryTree.find_in_bst(root, 12);
        node12.count = 3;
        
        BinaryTree.insert(root, 3);
        BinaryTreeNode node3 = BinaryTree.find_in_bst(root, 3);
        node3.count = 3;
        
        BinaryTree.insert(root, 4);
        BinaryTreeNode node4 = BinaryTree.find_in_bst(root, 4);
        node4.count = 2;
        
        BinaryTree.insert(root, 8);
        BinaryTreeNode node8 = BinaryTree.find_in_bst(root, 8);  
        node8.count = 1;
        
        BinaryTree.insert(root, 18);
        BinaryTreeNode node18 = BinaryTree.find_in_bst(root, 18);  
        node18.count = 2;
        
        BinaryTree.insert(root, 16);
        BinaryTreeNode node16 = BinaryTree.find_in_bst(root, 16);  
        node16.count = 1;
        
        BinaryTree.display_inorder(root);
        System.out.println();
        
        int n = 2;
        currentCount = 0;
        BinaryTreeNode nth_highest_node = findNthHighestInBST(root, n);
        System.out.println(nth_highest_node.data);  
        
        n = 1;
        currentCount = 0;
        nth_highest_node = findNthHighestInBST(root, n);
        System.out.println(nth_highest_node.data);
        
        n = 5;
        currentCount = 0;
        nth_highest_node = findNthHighestInBST(root, n);
        System.out.println(nth_highest_node.data);
        
        n = 30;
        currentCount = 0;
        nth_highest_node = findNthHighestInBST(root, n);
        String val = nth_highest_node == null ? "null" : String.valueOf(nth_highest_node.data);
        System.out.println(val);
    }  
}  