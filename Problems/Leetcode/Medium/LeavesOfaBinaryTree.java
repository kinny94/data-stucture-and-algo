/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
The essential of problem is not to find the leaves, but group leaves of same level together and also to cut the tree. This is the exact role backtracking plays. The helper function returns the level which is the distance from its furthest subtree leaf to root, which helps to identify which group the root belongs to
*/
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, root);
        return list;   

    }
    
    private int helper(List<List<Integer>> list, TreeNode node) {
        if (node == null) {
            return -1;
        }
        
        int leftLevel = helper(list, node.left);
        int rightLevel = helper(list, node.right);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        
        list.get(level).add(node.val);
        node.left = node.right = null;
        return level;
    }
}