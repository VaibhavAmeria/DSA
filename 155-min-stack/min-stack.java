class MinStack {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack() {
        st1 = new Stack <>();
        st2 = new Stack <>(); // for storing min
    }
    
    public void push(int val) {
        st1.push(val);
        if (st2.isEmpty() || val <= st2.peek()) {
            st2.push(val);
        }
    }
    
    public void pop() {
        if (st1.isEmpty()) {
            return;
        }
        int popped = st1.pop();
        if (!st2.isEmpty() && popped == st2.peek()) {
            st2.pop();
        }
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int getMin() {
        if (!st2.isEmpty()) {
            System.out.println(st2.peek());
            return st2.peek();
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */