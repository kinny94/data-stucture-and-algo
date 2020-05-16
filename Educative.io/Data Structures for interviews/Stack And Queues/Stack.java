class Stack {

    int top;
    int[] stack;

    Stack() {
        this.top = -1;
        this.stack = new int[100];
    }


    public boolean isEmpty() {
        return this.top == -1 ? true :  false;
    }

    public boolean isFull() {
        return this.top == this.stack.length - 1 ? true : false; 
    }


    public void push(int item) {
        if (!isFull()) { 
            this.stack[++top] = item;
        } else {
            System.out.println("Stack is full!!!");
        }
    }

    public int pop() {
        int returnValue = this.stack[top--];
        return returnValue;
    }

    public int peek() {
        return this.stack[top];
    }

    public void print(){
        for (int i=0; i<=top; i++) {
            System.out.print(stack[i] + " -> "); 
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Stack obj = new Stack();
        obj.push(5);
        obj.push(15);
        obj.push(25);
        obj.push(35);
        obj.push(45);

        obj.print();
        System.out.println(obj.peek());
        obj.pop();
        obj.print();

        System.out.println(obj.peek());
    }
}