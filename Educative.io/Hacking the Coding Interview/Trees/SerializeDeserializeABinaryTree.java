import java.util.Arrays;

class SerializeDeserializeABinaryTree {
    
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }

        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return root.val + "," + leftSerialized + rightSerialized;
    }

    public TreeNode deserialize(String s) {
        Queue<String> queue = new  LinkedList<>();
        queue.addAll(Arrays.asList(s.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String valueForNode = queue.poll();

        if (valueForNode.equals("X")) {
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));

        newNode.left = helper(queue);
        newNode.right = helper(queue);
        
        return newNode;
    }
}