class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int currentLength = 0;

        for (int i=0; i<s.length(); i++) {
            if (isPalindrome(s, i-currentLength-1, i)) {
                res = s.substring(i-currentLength-1, i+1);
                currentLength = currentLength + 2;   
            } else if (isPalindrome(s, i-currentLength, i)) {
                res = s.substring(i - currentLength, i+1);
                currentLength = currentLength + 1;
            }
        }

        return res;
    }

    public boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) {
            return false;
             
        }

        while(begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}