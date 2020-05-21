/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ValidateBST {
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer max, Integer min) {
        if (node == null) {
            return true;
        } else if (max != null && node.val >= max || min !- null && node.val <= min) {
            return false;
        } else {
            return helper(node.left, node.val, min) && helper(node.right, max, node.val);
        }
    }
}