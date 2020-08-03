// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
};

class DiameterOfATree {
    private static int treeDiameter = 0;

    public static int findDiameter(TreeNode root) {
        calculateHight(root);
        return treeDiameter;
    }

    private static int calculateHight(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int leftTreeHeight = calculateHight(currentNode.left);
        int rightTreeHeight = calculateHight(currentNode.right);

        int diameter = leftTreeHeight + rightTreeHeight + 1;
        treeDiameter = Math.max(diameter, treeDiameter);
        return Math.max(leftTreeHeight, rightTreeHeight)  + 1;
    } 

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + DiameterOfATree.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + DiameterOfATree.findDiameter(root));
    }
}