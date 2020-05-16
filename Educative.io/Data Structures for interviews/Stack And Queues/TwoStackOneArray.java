class TwoStackOneArray {
    
    int[] stack;
    int top1;
    int top2;

    TwoStackOneArray() {
        this.stack = new int[50];
        this.top1 = -1;
        this.top2 = this.stack.length;
    }

    public void push1(int item) {
        if (top1 != top2) {
            this.stack[++top1] = item;
        } else {
            System.out.println("Stack is full!!");
        }
    }

    public void push2(int item) {
        if (top2 != top1) {
            this.stack[--top2] = item;
        } else {
            System.out.println("Stack is full!!");
        }
    } 

    public void pop1() {
        if (this.top1 > -1) {
            this.top1--;
        } else {
            System.out.println("Stack  1 is empty!");
        }
    }

    public void pop2() {
        if (this.top2 < this.stack.length) {
            this.top2++;
        } else {
            System.out.println("Stack 2 is empty");
        }
    }

    public void print() {
        for (int i=0; i<this.stack.length; i++) {
            System.out.print(this.stack[i] + " => ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TwoStackOneArray obj = new TwoStackOneArray();
        obj.push1(1);
        obj.push1(2);
        obj.push1(3);
        obj.push1(4);
        obj.push2(99);
        obj.push2(98);
        obj.push2(97);
        obj.push2(96);
        obj.print();
        obj.pop1();
        obj.pop2();
        obj.push2(75);
        obj.push1(6);
        obj.print();

    }
}