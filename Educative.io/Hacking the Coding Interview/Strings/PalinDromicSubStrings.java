class PalinDromicSubStrings {
    
    public static int findPalindromesInSubString(String s, int left, int right) {
        int count=0;
        while(left>=0 && right<s.length()&& (s.charAt(left)==s.charAt(right))){
            System.out.println(s.substring(left, right + 1));
            left--;
            right++;
            count++;
        }
        return count;
    }
    
    public static int findAllPalindromeSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            count+=findPalindromesInSubString(s,i,i);//odd length
            count+=findPalindromesInSubString(s,i,i+1);//even length
        }
        return count;
    }
    
    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = findAllPalindromeSubstrings(str);
        System.out.println("Total palindrome substrings: " + count);
    }
}