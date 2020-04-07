class SubTreeOfAnotherTree {
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (checkSubTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean checkSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        
        return checkSubTree(s.left, t.left) && checkSubTree(s.right, t.right);
        
    }
    
}