import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SeriaLizeAndDerserializeABinaryTree {
    
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }

        String leftSeriaLized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return root.val + "," + leftSeriaLized + rightSerialized;
    }

    public TreeNode deserialize(String s) {
        if (s == null || s.equals(",")) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(s.split(",")));
        return helper(queue);
    }

    public TreeNode helper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        String value = queue.poll();


        if (value.equals("X")) {
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.parseInt(value));

        newNode.left = helper(queue);
        newNode.right = helper(queue);

        return newNode;
    }
}