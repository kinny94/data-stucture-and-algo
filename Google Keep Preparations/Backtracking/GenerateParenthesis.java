import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, "", 0, 0, n);
            return result;
    }

    private void backtrack(List<String> result, String curreString, int open, int close, int max) {
        if (curreString.length() == max * 2) {
            result.add(curreString);
            return;
        }
        if (open < max) {
            backtrack(result, curreString + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(result, curreString + ")", open, close + 1, max);
        }
    }
}