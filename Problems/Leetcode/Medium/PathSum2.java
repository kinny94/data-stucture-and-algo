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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathSum(root, sum, currentPath, result);
        return result;
    }
    
    private void findPathSum(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        currentPath.add(node.val);
        
        if (node.val == sum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPathSum(node.left, sum - node.val, currentPath, result);
            findPathSum(node.right, sum - node.val, currentPath, result);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
 
}