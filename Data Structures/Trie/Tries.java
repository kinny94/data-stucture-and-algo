import java.util.ArrayList;
import java.util.List;

class Node {
    
    private String character;
    private Node[] children;
    private boolean isVisited;
    private boolean isLeaf;
    private int value;

    Node(String character) {
        this.character = character;
        this.children = new Node[26];
    }

    public void setChild(int index, Node node, int value) {
        node.setValue(value);
        this.children[index] = node;
    }

    public Node getChild(int index) {
        return this.children[index];
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Tries {

    private Node root;
    private int indexOfSingleChilld;

    Tries() {
        this.root = new Node(""); // "" is gonna be the prefix
    }

    public void insert(String word, int value) {
        Node tempNode = this.root;

        for (int i=0; i<word.length(); i++) {
            char c =  word.charAt(i);
            int asciiChildredIndexValue = c - 'a';

            if (tempNode.getChild(asciiChildredIndexValue) == null) {
                Node newNode = new Node(String.valueOf(c));
                tempNode.setChild(asciiChildredIndexValue, newNode, value);
                tempNode = newNode;
            } else {
                tempNode = tempNode.getChild(asciiChildredIndexValue);
            }
        }

        tempNode.setLeaf(true);
    }

    public boolean search(String word) {
        Node tempNode = root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            int asciiChildredIndexValue = c - 'a';

            if (tempNode.getChild(asciiChildredIndexValue) == null) {
                return false;
            } else {
                tempNode = tempNode.getChild(asciiChildredIndexValue);
            }
        }

        if (!tempNode.isLeaf()) {
            return false;
        }

        return true;
    }

    public Integer searchAsMap(String word) {
        Node tempNode = this.root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int asciiChildredIndexValue = c - 'a';

            if (tempNode.getChild(asciiChildredIndexValue) != null) {
                tempNode = tempNode.getChild(asciiChildredIndexValue);
            } else {
                return null;
            }
        }

        return tempNode.getValue();
    }

    private void collect(Node node, String prefix, List<String> allwords) {
        if (node == null) {
            return;
        }

        if (node.isLeaf()) {
            allwords.add(prefix);
        }

        for (Node childNode: node.getChildren()) {
            if (childNode == null) continue;
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix + childCharacter, allwords);
        }
    }

    public List<String> allWordsWithPrefix(String prefix) {
        Node tempNode = root;

        List<String> allwords = new ArrayList<>();

        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            int asciiChildredIndexValue = c - 'a';

            if (tempNode.getChild(asciiChildredIndexValue) != null) {
                tempNode = tempNode.getChild(asciiChildredIndexValue);
            } else {
                return allwords;
            }
        }

        collect(tempNode, prefix, allwords);
        return allwords;
    }

    private int countNumberOfChilderen(Node trieNode ) {
        int numOfChildren = 0;

        for (int i=0; i<trieNode.getChildren().length; i++) {
            if (trieNode.getChild(i) != null ){
                numOfChildren++;
                indexOfSingleChilld = i;
            }
        }
        
        return numOfChildren;
    }

    public String longestCommonPrefix() {
        Node tempNode = root;
        String longestCommonPrefix = "";

        while (countNumberOfChilderen(tempNode) == 1 && !tempNode.isLeaf()) {
            tempNode = tempNode.getChild(indexOfSingleChilld);
            longestCommonPrefix = longestCommonPrefix + String.valueOf((char) (indexOfSingleChilld + 'a'));
        }

        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("havana", 1);
        List<String> list = trie.allWordsWithPrefix("tatiana");
        System.out.println(list);
        // trie.insert("john", 2);
        // trie.insert("johna", 3);
        // trie.insert("jana", 3);
        // trie.insert("jane", 3);
        // trie.insert("jade", 3);
        // // trie.insert("helloworld", 4);
        // // trie.insert("adam", 4);
        // // trie.insert("badass", 4);

        // System.out.println(trie.search("joe"));
        // System.out.println(trie.search("joee"));
        // System.out.println(trie.search("jon"));

        // System.out.println(trie.searchAsMap("joe"));
        // System.out.println(trie.searchAsMap("johna"));

        // System.out.println();
        // List<String> list = trie.allWordsWithPrefix("jo");
        // System.out.println(list);

        // System.out.println();
        // List<String> list2 = trie.allWordsWithPrefix("jo");
        // System.out.println(list2);

        // System.out.println();
        // List<String> list15 = trie.allWordsWithPrefix("x");
        // System.out.println(list15);

        // System.out.println();
        // List<String> list3 = trie.allWordsWithPrefix("j");
        // System.out.println(list3);

        // System.out.println();
        // List<String> list4 = trie.allWordsWithPrefix("ja");
        // System.out.println(list4);

        // // the following is used for sorting as well
        // System.out.println();
        // List<String> list5 = trie.allWordsWithPrefix("");
        // System.out.println(list5);

        // System.out.println();
        // System.out.println(trie.longestCommonPrefix());


    }
}