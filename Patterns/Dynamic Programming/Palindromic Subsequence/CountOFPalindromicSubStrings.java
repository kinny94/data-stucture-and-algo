class CountOFPalindromicSubStrings {

    // better solution
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=extractPalindrome(s,i,i);//odd length
            count+=extractPalindrome(s,i,i+1);//even length
        }
        return count;
    }
    
    public int extractPalindrome(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length()&& (s.charAt(left)==s.charAt(right))){
            left--;
            right++;
            count++;
        }
        return count;
    }

    public int findCPS(String st) {
        boolean[][] dp = new boolean[st.length()][st.length()];
        int count = 0;
        
        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = true;
            count++;
        }
        
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        CountOFPalindromicSubStrings cps = new CountOFPalindromicSubStrings();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    }
}