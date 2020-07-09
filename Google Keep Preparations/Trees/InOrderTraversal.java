import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        
        if (root == null) {
            return results;
        }
        
        helper(root, results);
        return results;
    } 
    
    private void helper(TreeNode node, List<Integer> results) {
        if (node.left != null) {
            helper(node.left, results);
        }
        
        results.add(node.val);
        
        if (node.right != null) {
            helper(node.right, results);
        }
    }    
}