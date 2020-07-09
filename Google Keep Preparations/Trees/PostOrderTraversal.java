import java.util.ArrayList;
import java.util.List;

class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
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
        
        if (node.right != null) {
            helper(node.right, results);
        }
        
        results.add(node.val);
    }    
}