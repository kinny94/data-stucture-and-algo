class ReverseWords {
    // Null terminating strings are not used in java
    public static void strRev(char[] str, int start, int end) {
        if (str == null || str.length < 2) {
            return;
        }
        
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void reverseWords(char[] sentence) {
        // Here sentence is a null-terminated string ending with char '\0'.
        if (sentence == null || sentence.length == 0) {
            return;
        }
        
        // To reverse all words in the string, we will first reverse
        // the string. Now all the words are in the desired location, but
        // in reverse order: "Hello World" -> "dlroW olleH".
        int len = sentence.length;
        strRev(sentence, 0, len - 2);
        
        // Now, let's iterate the sentence and reverse each word in place.
        // "dlroW olleH" -> "World Hello"
        int start = 0;
        int end;
        
        while (true) {
            // find the  start index of a word while skipping spaces.
            while (sentence[start] == ' ') {
                ++start;
            }
            
            if (start >= sentence.length - 1) {
                break;
            }
            
            // find the end index of the word.
            end = start + 1;
            while (end < sentence.length - 1 && sentence[end] != ' ') {
                ++end;
            }
            
            // let's reverse the word in-place.
            strRev(sentence, start, end - 1);
            start = end;
        }
    }
    
    static char[] getArray(String t) {
        char[] s = new char[t.length() + 1];
        int i = 0;
        for (; i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        return s;
    }
    
    public static void main(String[] args) {
        char[] s = getArray("Hello World!");
        System.out.println(s);
        reverseWords(s);
        System.out.println(s);
    }
}