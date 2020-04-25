import java.util.ArrayList;

class PrintRootToLeafPath {
    public List<Integer> getPaths(TreeNode root) {
        List<Integer> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        addPaths(root, paths);
    }

    private void addPaths(TreeNode node,List<Integer> list) {
        list.add(node.val);

        if (node.left == null && node.right == null) {
            printList(list);
            return;
        }

        addPaths(root.left, new ArrayList<Integer>(list));
        addPath(root.right,  new ArrayList<Integer>(list));
    }

    private void printList(ArrayList<Integer> path) { 
        for (Integer i: path) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}