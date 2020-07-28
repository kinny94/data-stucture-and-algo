class LongestPalindronmicSubstring {

    // better solution
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i=0; i<s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len) / 2;
            }
        }

        return s.substring(start, end + 1);
    }    

    public int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public int findLPSLength(String st) {

        boolean[][] dp = new boolean[st.length()][st.length()];

        for (int i=0; i<st.length(); i++){
            dp[i][i] = true;
        }

        int maxLength = 1;
        for (int start = st.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < st.length(); end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        maxLength = Math.max(maxLength, end - start + 1);
                    }
                }
            }
        } 

        return maxLength;
    }    

    public static void main(String[] args) {
        LongestPalindronmicSubstring lps = new LongestPalindronmicSubstring();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cdpdd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}