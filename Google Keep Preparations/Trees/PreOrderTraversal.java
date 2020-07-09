import java.util.ArrayList;
import java.util.List;

class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        
        if (root == null) {
            return results;
        }
        
        helper(root, results);
        return results;
    }
    
    private void helper(TreeNode node, List<Integer> results) {
        
        results.add(node.val);
        
        if (node.left != null) {
            helper(node.left, results);
        }
        
        if (node.right != null) {
            helper(node.right, results);
        }
    }
}