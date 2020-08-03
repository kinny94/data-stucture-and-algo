class ParenthesisString {
    String str;
    int openCount;
    int closeCount;
    
    ParenthesisString(String str, int openCount, int closeCount) {
        this.str = str;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesisString> queue = new LinkedList<>();
        queue.offer(new ParenthesisString("", 0, 0));
        
        while (!queue.isEmpty()) {

            ParenthesisString ps = queue.poll();
            if (ps.openCount == n && ps.closeCount == n) {
                result.add(ps.str);
            } else {
                if (ps.openCount < n) {
                    queue.add(new ParenthesisString(ps.str + "(", ps.openCount + 1, ps.closeCount));
                }
                
                if (ps.openCount > ps.closeCount) {
                    queue.add(new ParenthesisString(ps.str + ")", ps.openCount, ps.closeCount + 1));
                }
            }
        }
        
        return result;
    }   
}