/*
    Step 1: Start a for loop to point at every single character from where we will trace the palindrome string.
    checkPalindrome(s,i,i); //To check the palindrome of odd length palindromic sub-string
    checkPalindrome(s,i,i+1); //To check the palindrome of even length palindromic sub-string

    Step 2: From each character of the string, we will keep checking if the sub-string is a palindrome and increment the palindrome count. To check the palindrome, keep checking the left and right of the character if it is same or not.
*/
class PalindromicStrings {
    
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
}