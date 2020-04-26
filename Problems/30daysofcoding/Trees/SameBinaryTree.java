class SameBinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q== null) {
            return false;
        }   
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSame(p.right, q.right) && isSame(p.left, q.left);
    }
    
    private boolean isSame(TreeNode node1, TreeNode node2) {
        
        if (node1 == null && node2 == null) {
            return true;
        }
        
        if (node1 == null || node2 == null) {
            return false;
        }
        
        if (node1.val != node2.val) {
            return false;
        }
        
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}