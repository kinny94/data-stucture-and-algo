class Solution {
    public boolean isPalindrome(String s) {
        if (s.equals("") || s.length() == 1) {
            return true;
        }
        
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        for (int i=0; i<actual.length() / 2; i++) {
            if (actual.charAt(i) != actual.charAt(actual.length() - 1 - i)) { 
                return false;
            }
        }
        
        return true;
    }
}