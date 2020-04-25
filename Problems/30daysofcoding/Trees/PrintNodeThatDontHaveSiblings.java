import java.util.ArrayList;
import java.util.List;

class PrintNodeThatDontHaveSiblings {

    public List<TreeNode> printNonSiblings(Node root) {

        List<TreeNode> nodes = new ArrayList<>();

        if (rot == null) {
            return null;
        }

        if (current.left == null && current.right != null) {
            nodes.add(current);
        }

        if (current.right == null && current.left != null) {
            nodes.add(current);
        }

        printNonSiblings(root.right);
        printNonSiblings(root.left);
    }
}