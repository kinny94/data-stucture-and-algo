class TrieWords {
    //Recursive Function to generate all words
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
    
    public static ArrayList < String > findWords(TrieNode root) {
        ArrayList < String > result = new ArrayList < String > ();
        char[] chararr = new char[20];
        getWords(root, result, 0, chararr);
        return result;
    }
}