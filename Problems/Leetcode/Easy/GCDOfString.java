/*
    If longer string starts with shorter string, cut off the common prefix part of the longer string; repeat till one is empty, then the other is gcd string;
    If the longer string does NOT start with the shorter one, there is no gcd string.
*/
class GCDOfString {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) { // make sure str1 is not shorter than str2.
            return gcdOfStrings(str2, str1); 
        }else if (!str1.startsWith(str2)) { // shorter string is not common prefix.
            return ""; 
        }else if (str2.isEmpty()) { // gcd string found.
            return str1;
        }else { // cut off the common prefix part of str1.
            return gcdOfStrings(str1.substring(str2.length()), str2); 
        }
    }
}