class Sort {
    
    //Recursive Function to generate all words in alphabetic order
    public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str) {
        //Leaf denotes end of a word
        if (root.isEndWord) {
            //current word is stored till the 'level' in the character array
            String temp = "";
            for (int x = 0; x < level; x++) {
                temp += Character.toString(str[x]);
            }
            result.add(temp);
        }
        
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                //Non-null child, so add that index to the character array
                str[level] = (char)(i + 'a');
                getWords(root.children[i], result, level + 1, str);
            }
        }
    }
    public static ArrayList<String> sortArray(String[] arr){
        ArrayList<String> result = new ArrayList<String>();
        
        //Creating Trie and Inserting words from array
        Trie trie = new Trie();
        for (int x = 0; x < arr.length ; x++)
        trie.insert(arr[x]);
        
        char[] char_arr = new char[20];
        getWords(trie.getRoot(),result,0,char_arr);  
        return result;
    }
}