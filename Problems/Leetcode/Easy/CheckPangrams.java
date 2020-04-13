class CheckPangrams {
    
    public boolean isPangram(String str) {
        int index = 0;
        boolean[] mark = new boolean[26];

        for (int i=0; i<str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                index = str.charAt(i) - 'A'; 
            } else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                index = str.charAt(i) - 'a'; 
            } else {
                continue;
            }

            mark[index] = true;
                
        }   

          // Return false if any character is unmarked 
        for (int i = 0; i <= 25; i++) {
            if (mark[i] == false) {
                return (false); 
            }  
        }
        
        return true;
    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog"; 
        CheckPangrams cp = new CheckPangrams();
  
        if (cp.isPangram(str)) 
            System.out.print(str + " is a pangram."); 
        else
            System.out.print(str + " is not a pangram."); 
    }
}