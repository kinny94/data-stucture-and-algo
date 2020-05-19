class DictWord
{
    public static Object isFormationPossible(String[] dict,String word)
    {
        if(word.length() < 2 || dict.length < 2){
            return false;
        }
        
        //Create Trie and insert dictionary elements in it
        Trie trie = new Trie();
        
        for(int i = 0; i < dict.length; i++){
            trie.insert(dict[i]);
        }
        
        for(int i = 0; i < word.length(); i++){
            //Slice the word into two strings in each iteration
            String first = word.substring(0, i);
            String second = word.substring(i, word.length());
            
            //If both substrings are present in the trie, the condition is fulfilled
            if(trie.search(first) && trie.search(second)){
                return true;
            }
        }
        
        return false;
    }
}