/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode node, List<Integer> result) {
        
        if (node.left != null) {
            helper(node.left, result);
        }  
        
        result.add(node.val);
    
        if (node.right != null) {
            helper(node.right, result);
        } 
    }
}