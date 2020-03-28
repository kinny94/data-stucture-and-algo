class Stack {

    private int[] stack;
    private int top;
    private int size;
    
    Stack(int size) {
        this.top = -1;
        this.size = size;
        this.stack = new int[size];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isStackFull() {
        return this.top == this.size;
    }

    public void push(int item) {
        if (!isStackFull()) {
            this.stack[++this.top] = item;
        } else {
            System.out.println("Stack is full!");
        }
    }

    public int pop() {
        if (!this.isEmpty()) {
            return this.stack[this.top--];
        } else {
            System.out.println("Stack is already empty");
            return -1;
        }
    }

    public int peek() {
        return this.stack[top];
    }

    public void clear() {
        for (int i=0; i<this.stack.length; i++){
            this.stack[i] = -1;
        }
    }

    public int size() {
        return this.top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.pop();
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.push(6);
        System.out.println(stack.peek());
        stack.push(12);
        stack.push(123);
        stack.push(22);
        System.out.println(stack.size());
                
    }

}