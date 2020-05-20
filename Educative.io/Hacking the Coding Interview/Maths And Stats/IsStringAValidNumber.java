class NumberValid{  
    enum STATE { START, INTEGER, DECIMAL, UNKNOWN, AFTERDECIMAL};
    
    static STATE getNextState(STATE currentState, char ch) {
        switch(currentState) {
            case START:
            case INTEGER:
            if (ch == '.') {
                return STATE.DECIMAL;
            } else if (ch >= '0' && ch <= '9') {
                return STATE.INTEGER;
            } else {
                return STATE.UNKNOWN;
            }
            case DECIMAL:
            if (ch >= '0' && ch <= '9') {
                return STATE.AFTERDECIMAL;
            } else {
                return STATE.UNKNOWN;
            }
            case AFTERDECIMAL: 
            if (ch >= '0' && ch <= '9') {
                return STATE.AFTERDECIMAL;
            } else {
                return STATE.UNKNOWN;
            }
        }
        return STATE.UNKNOWN;
    }
    
    static boolean isNumberValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }
        
        STATE currentState = STATE.START;
        
        while (i < s.length()) {
            currentState = getNextState(currentState, s.charAt(i));
            
            if (currentState == STATE.UNKNOWN) {
                return false;
            }
            
            i = i + 1;
        }
        
        if (currentState == STATE.DECIMAL)
        return false;
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("Is the number valid 4.325? " + isNumberValid("4.325"));
        System.out.println("Is the number valid 1.1.1? " + isNumberValid("1.1.1"));
        System.out.println("Is the number valid 222? " + isNumberValid("222"));
        System.out.println("Is the number valid 22.? " + isNumberValid("22."));
        System.out.println("Is the number valid 0.1? " + isNumberValid("0.1"));
        System.out.println("Is the number valid 22.22.? " + isNumberValid("22.22."));
        System.out.println("Is the number valid 1.? " + isNumberValid("1."));    
    }
}