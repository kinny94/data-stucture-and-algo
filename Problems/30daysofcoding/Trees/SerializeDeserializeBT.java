import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SerializeDeserializeBT {

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }

        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return root.val + "," + leftSerialized + "," + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }
    
    private TreeNode deserializeHelper(Queue<String> nodesLeft) {
        String valueForNodes = nodesLeft.poll();
        if (valueForNodes.equals("X")) {
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNodes));
        newNode.left = deserializeHelper(nodesLeft);
        newNode.right = deserializeHelper(nodesLeft);

        return newNode;
    }
}