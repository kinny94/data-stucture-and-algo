package Problems.Leetcode.Easy;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        
        int i = 0, j = s.length()-1;
        while(i < j && s.charAt(i) == s.charAt(j)) {i++; j--;}
        if(i >= j) return true;
        
        int i1 = i, j1 = j-1; 
        while(i1 < j1 && s.charAt(i1) == s.charAt(j1)) {i1++; j1--;}
        if(i1 >= j1) return true;
        
        int i2 = i+1, j2 = j;
        while(i2 < j2 && s.charAt(i2) == s.charAt(j2)) {i2++; j2--;}
        if (i2 >= j2) return true;
        
        return false;
    }
}