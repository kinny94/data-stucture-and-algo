class NodeAtKDistanceFromRoot {
    
    public static String findKNodes(Node root, int k) {

        StringBuilder result = new StringBuilder(); //StringBuilder is immutable
        result = findK(root, k, result);
    
        return result.toString();
      }
    
      //Helper recursive function to traverse tree and append all the nodes 
      // at k distance into result StringBuilder
      public static StringBuilder findK(Node root, int k, StringBuilder result) {
    
        if (root == null) return null;
    
        if (k == 0) {
          result.append(root.getData() + ",");
        }
        else {
          //Decrement k at each step till you reach at the leaf node 
          // or when k == 0 then append the Node's data into result string
          findK(root.getLeftChild(), k - 1, result);
          findK(root.getRightChild(), k - 1, result);
        }
        return result;
      }
}