class Node {
    
    private char character;
    private Node leftNode;
    private Node middleNode;
    private Node rightNode;
    private int value;
    
    public Node(char character) {
        this.character = character;
    }
    
    public char getCharacter() {
        return character;
    }
    
    public void setCharacter(char character) {
        this.character = character;
    }
    
    public Node getLeftNode() {
        return leftNode;
    }
    
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
    
    public Node getMiddleNode() {
        return middleNode;
    }
    
    public void setMiddleNode(Node middleNode) {
        this.middleNode = middleNode;
    }
    
    public Node getRightNode() {
        return rightNode;
    }
    
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
}

class TST {
    
    private Node rootNode;
    
    public void put(String key, int value){
        rootNode = put(rootNode,key,value,0);
    }
    
    private Node put(Node node, String key, int value, int index) {
        
        char c = key.charAt(index);
        
        if( node == null ){
            node = new Node(c);
        }
        
        if( c < node.getCharacter() ){
            node.setLeftNode(put(node.getLeftNode(),key,value,index));
        }else if( c > node.getCharacter() ){
            node.setRightNode(put(node.getRightNode(),key,value,index));
        }else if( index < key.length()-1 ){
            node.setMiddleNode(put(node.getMiddleNode(),key,value,index+1));
        }else{
            node.setValue(value);
        }
        
        return node;
    }
    
    public Integer get(String key){
        
        Node node = get(rootNode,key,0);
        
        if( node == null ){
            return null;
        }
        
        return node.getValue();
    }
    
    private Node get(Node node, String key, int index) {
        
        if( node == null ) return null;
        
        char c = key.charAt(index);
        
        if( c < node.getCharacter() ){
            return get(node.getLeftNode(),key,index);
        }else if( c > node.getCharacter() ){
            return get(node.getRightNode(), key, index);
        }else if( index < key.length()-1){
            return get(node.getMiddleNode(),key,index+1);
        }else{
            return node;
        }
        
    }
    public static void main(String[] args) {
        TST tst = new TST();
        tst.put("apple", 1);
        tst.put("orange", 2);
        
        System.out.println(tst.get("apple"));
    }
}