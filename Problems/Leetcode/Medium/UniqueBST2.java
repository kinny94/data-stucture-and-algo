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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        return findUniqueTreeHelper(1, n);
    }
    
    public List<TreeNode> findUniqueTreeHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i=start; i<=end; i++) {
            List<TreeNode> leftSubTrees = findUniqueTreeHelper(start, i-1);
            List<TreeNode> rightSubTrees = findUniqueTreeHelper(i+1, end);

            for (TreeNode leftTree: leftSubTrees) {
                for (TreeNode rightTree: rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }

        return result;
    }
}