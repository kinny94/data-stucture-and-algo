class NumWords {
    public static int totalWords(TrieNode root) {
      int result = 0;
  
      // Leaf denotes end of a word
      if (root.isEndWord)
        result++;
  
      for (int i = 0; i < 26; i++)
        if (root.children[i] != null)
          result += totalWords(root.children[i]);
      return result;
    }
  }