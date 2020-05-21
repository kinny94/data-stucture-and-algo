import java.util.Arrays;
import java.util.LinkedList;

class SerializeDeserializeABinaryTree {
    
    public String serialize(TreeNode root) {

        if (root == null) {
            return "X,";
        } 

        String leftSerialize = serialize(root.left);
        String rightSerilize = serialize(root.right);

        return root.val + "," + leftSerialize + rightSerilize;
    }

    public TreeNode deserialize(String s) {
        if (s.equals("X")) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(s.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        
        if (queue.isEmpty()) {
            return null;
        }

        String current= queue.poll();
        
        if (current.equals("X")) {
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.parseInt(current));
        newNode.left = helper(queue);
        newNode.right = helper(queue);

        return newNode;
    } 
}