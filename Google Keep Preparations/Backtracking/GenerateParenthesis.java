import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        
        List<String> results = new ArrayList<>();
        
        if (n == 0) {
            return results;
        }

        generate(results, "", 0, 0, n);
        return results;
    }   

    private void generate(List<String> results, String currentString, int open, int close, int m) {
        if (currentString.length() == m * 2) {
            results.add(currentString);
            return;
        }

        if (open < m) {
            generate(results, currentString + "(", open + 1, close, m);
        }

        if (close < open) {
            generate(results, currentString + ")", open, close + 1, m);
        }
    }
}