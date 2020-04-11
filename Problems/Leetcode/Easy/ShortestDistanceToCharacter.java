class ShortestDistanceToCharacter {
    public int[] shortestToChar(String S, char C) {
        int pos = -S.length();
        int[] res = new int[S.length()];
        
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == C) {
                pos = i;
            } 
            res[i] = i - pos;
        }
        

        for (int i=pos; i>=0; i--) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }
        
        return res;
     }
}