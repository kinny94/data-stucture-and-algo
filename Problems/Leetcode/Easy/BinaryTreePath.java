/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        getPathToLeaf(root, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void getPathToLeaf(TreeNode node,  List<Integer> current, List<String> result) {
        
        if (node == null) {
            return;
        }
        
        if (node != null) {
            current.add(node.val);
        }
        
        if (node.right == null && node.left == null) {
            String s = getString(current);
            result.add(s);
            return;
        }
        
        getPathToLeaf(node.left, new ArrayList<Integer>(current), result);
        getPathToLeaf(node.right, new ArrayList<Integer>(current), result);
    }
    
    private String getString(List<Integer> list) {
        
        StringBuilder sb  = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            if (i != list.size() - 1) {
                sb.append(Integer.toString(list.get(i)) + "->");
            } else {
                sb.append(Integer.toString(list.get(i)));
            }
        }   
        
        return sb.toString();
    }
}