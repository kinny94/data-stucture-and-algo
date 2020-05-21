class ConnectSiblings{
    private static BinaryTreeNode connectNextLevel(BinaryTreeNode head) {		  	  
        BinaryTreeNode current = head;
        BinaryTreeNode nextLevelHead = null;
        BinaryTreeNode prev = null;
        
        while (current != null) {		  
            if(current.left != null && current.right != null){
                if(nextLevelHead == null){
                    nextLevelHead = current.left;
                }
                current.left.next = current.right;
                
                if(prev != null){
                    prev.next = current.left;
                }
                prev = current.right;
            }
            else if(current.left != null){
                if(nextLevelHead == null){
                    nextLevelHead = current.left;
                }
                if(prev != null){
                    prev.next = current.left;
                }
                prev = current.left;
            }
            else if(current.right != null){
                if(nextLevelHead == null){
                    nextLevelHead = current.right;
                }
                
                if(prev != null){
                    prev.next = current.right;
                }
                prev = current.right;
            }
            current = current.next;
        }
        
        if(prev != null){
            prev.next = null;  
        }
        
        return nextLevelHead;
    }
    
    public static void populateSiblingPointers(BinaryTreeNode root) {
        
        if (root == null) {
            return;
        }
        
        root.next = null;
        
        do {
            root = connectNextLevel(root);
        } while (root != null);
    }
    
    static List<Integer> getLevelOrderUsingNext(BinaryTreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        while (root != null) {
            BinaryTreeNode head = root;
            BinaryTreeNode next_head = null;
            while (head != null) {
                output.add(head.data);
                
                if (next_head == null) {
                    next_head = head.left != null ? head.left : head.right;
                }
                head = head.next;
            }
            root = next_head;
        }
        return output;
    }
    
    public static void main(String []args){
        List<Integer> v = new ArrayList<Integer>();
        v.add(100);v.add(50);v.add(200);v.add(25);v.add(75);v.add(300);
        v.add(10);v.add(350);v.add(15);
        
        BinaryTreeNode head = BinaryTree.createBST(v);
        
        List<Integer> v1 = BinaryTree.getLevelOrder(head);
        
        populateSiblingPointers(head);
        
        List<Integer> result = getLevelOrderUsingNext(head);
        
        System.out.println(result);
        System.out.println(head.next); //null
        System.out.println(head.left.next.data); //200
        System.out.println(head.left.right.next.data); //300
        System.out.println(head.right.right.next); //null
    }
}  