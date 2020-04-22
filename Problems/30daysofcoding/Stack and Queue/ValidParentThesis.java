import java.util.*;

class ValidParentThesis {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                switch(c) {
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParentThesis obj = new ValidParentThesis();
        System.out.println(obj.isValid("([)]"));
    }
}