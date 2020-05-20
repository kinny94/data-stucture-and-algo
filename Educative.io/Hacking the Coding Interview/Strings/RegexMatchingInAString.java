class RegxMatch{
    static boolean regxMatchRec(String text, String pattern) {
        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        
        if (!text.isEmpty() && pattern.isEmpty()) {
            return false;
        }
        
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            
            String remainingPattern = pattern.substring(2);
            String remainingText = text;
            
            for (int i = 0; i < text.length() + 1; ++i) {
                if (regxMatchRec(remainingText, remainingPattern)) {
                    return true;
                }
                
                if (remainingText.isEmpty()) {
                    return false;
                }
                
                if (pattern.charAt(0) != '.' && 
                remainingText.charAt(0) != pattern.charAt(0)) {
                    return false;
                }
                
                remainingText = remainingText.substring(1);
            }
        } 
        
        if (text.isEmpty() || pattern.isEmpty()) {
            return false;
        }
        
        if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
            String remainingText = "";
            if (text.length() >= 2) {
                remainingText = text.substring(1);
            }
            
            String remainingPattern = "";
            if (pattern.length() >= 2) {
                remainingPattern = pattern.substring(1);
            } 
            
            return regxMatchRec(remainingText, remainingPattern);
        } 
        
        return false;
    }
    
    public static boolean regxMatch(String s, String p) {
        return regxMatchRec(s, p);
    }
    
    public static void main(String[] args) {
        String s = "fabbbc";
        String p = ".ab*c";
        boolean output2 = regxMatch(s, p);
        
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        
        if (output2) {
            System.out.print(s + " " + p + " match");
        } else {
            System.out.print(s + " " + p + " did not match.");
        }
    }
}