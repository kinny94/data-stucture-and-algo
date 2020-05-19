import java.util.Arrays;

class TrieNode {
    
    TrieNode[] children;
    boolean isEndWord;
    
    TrieNode() {
        this.isEndWord = false;
        this.children = new TrieNode[26];
    }
    
    public void markAsLeaf() {
        this.isEndWord = true;
    }
    
    public void unMarkAsLeaf() {
        this.isEndWord = false;
    }
}

class Tries {
    private TrieNode root;
    
    Tries() {
        this.root = new TrieNode();
    }
    
    public int getIndex(char t) {
        return t - 'a';
    }
    
    public void insert(String key) {
        if (key == null) {
            System.out.println("This key cannot be inserted!!");
            return;
        }
        
        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;
        
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            
            currentNode = currentNode.children[index];
        }
        
        currentNode.markAsLeaf();
    }
    
    public boolean search(String key) {
        if (key == null) {
            return false;
        }
        
        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;
        
        
        for (int i=0; i<key.length(); i++) {
            index = getIndex(key.charAt(i));
            
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        
        if (currentNode.isEndWord) {
            return true;
        }
        
        return false;
    }
    
    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.children.length; i++){
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }
    
    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level)
    {
        boolean deletedSelf = false;

        if (currentNode == null) {
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)) {
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        } else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord) {
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)){
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else {
                    currentNode = null;
                    deletedSelf = true;
                }
            } else {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    //Function to delete given key from Trie
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }
    
    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
        "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Tries t = new Tries();
        
        System.out.println("Keys: "+ Arrays.toString(keys));
        
        // Construct trie
        
        int i;
        for (i = 0; i < keys.length ; i++)
        t.insert(keys[i]);
        
        // Search for different keys and delete if found
        if(t.search("the") == true)
        {
            System.out.println("the --- " + output[1]);
            t.delete("the");
            System.out.println("Deleted key \"the\"");
        }
        else System.out.println("the --- " + output[0]);
        
        if(t.search("these") == true)
        {
            System.out.println("these --- " + output[1]);
            t.delete("these");
            System.out.println("Deleted key \"these\"");
        }
        else System.out.println("these --- " + output[0]);
        
        if(t.search("abc") == true)
        {
            System.out.println("abc --- " + output[1]);
            t.delete("abc");
            System.out.println("Deleted key \"abc\""); 
        }
        else System.out.println("abc --- " + output[0]);
        
        // check if the string has deleted correctly or still present
        if(t.search("abc") == true)
        System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);
    }
}