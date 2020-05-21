class InorderSuccessor {
    static BinaryTreeNode findMin(BinaryTreeNode root) {
        if(root == null)
        return null;
        
        while(root.left != null) {
            root = root.left;
        }
        
        return root;
    }
    
    static BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {
        
        if(root == null) {
            return null;
        }
        
        BinaryTreeNode successor = null;
        
        while (root != null) {
            
            if(root.data < d) {
                root = root.right;
            }
            else if(root.data > d) {
                successor = root;
                root = root.left;
            }
            else {
                if(root.right != null)
                {
                    successor = findMin(root.right);
                }
                break;
            }
        }
        return successor;
    }
    
    /// Test Program.
    public static void main(String[] args) {
        ArrayList<Integer> origData = new ArrayList<Integer>();
        origData.add(100);origData.add(50);origData.add(200);origData.add(25);origData.add(75);
        origData.add(125);origData.add(350);
        BinaryTreeNode root = BinaryTree.createBST(origData);
        
        ArrayList<Integer> allData = BinaryTree.BSTtoArraylist(root);
        
        for (Integer d : origData) {
            BinaryTreeNode successor = inorderSuccessorBST(root, d);
            int i = allData.indexOf(d);
            Integer expectedVal = null;
            if (i < allData.size() - 1) {
                expectedVal = allData.get(i + 1);
            }
            
            if (successor != null) {
                if (expectedVal.intValue() != successor.data) {
                    System.out.println("*******" + d + " ==== " + expectedVal + ", " + successor.data + "*****");
                    //System.out.println(expectedVal.intValue() == successor.data);
                }
            }  else {
                //System.out.println(successor == null);
            }    
            if (successor != null) {
                System.out.print("(" + d + ", " + successor.data + ") ");
            } else { 
                System.out.print("(" + d + ", null) ");
            }
        }
    }
}  