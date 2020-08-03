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
    public int pathSum(TreeNode root, int sum) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathSum(root, sum, currentPath);
    }
    
    private int countPathSum(TreeNode currentNode, int sum, List<Integer> currentPath) {
        if (currentNode == null) {
            return 0;
        }
        
        currentPath.add(currentNode.val);
        
        int pathSum = 0;
        int pathCount = 0;
        
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            
            if (pathSum == sum) {
                pathCount++;
            }
                
        } 
        
        pathCount += countPathSum(currentNode.left, sum, currentPath);
        pathCount += countPathSum(currentNode.right, sum, currentPath);
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }
}