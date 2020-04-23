import java.util.*; 
class MinAddToMakeParenthesisValid {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c: s.toCharArray()) {
            switch(c) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;                
                case ']':
                    if (!stack.isEmpty()  && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        count++;
                    } 
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        count++;
                    } 
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        count++;
                    } 
                    break;
            }

        }
        return count + stack.size();
    }

    public static void main(String[] args) {
        MinAddToMakeParenthesisValid obj = new MinAddToMakeParenthesisValid();
        System.out.println(obj.minAddToMakeValid("()))(("));
    }
}