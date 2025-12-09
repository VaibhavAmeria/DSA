import java.util.Stack;

class MinStack {
    // 1. Change stack to store Long to prevent overflow during encoding
    private Stack<Long> stack;
    private int min; // We can still keep min as int, or upgrade to long for consistency

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        // Cast to long immediately for calculations
        long longVal = (long) val;
        
        if (stack.isEmpty()) {
            min = val;
            stack.push(longVal);
        } else if (longVal < min) {
            // 2. Use 2L to force long arithmetic
            stack.push(2 * longVal - min);
            min = val;
        } else {
            stack.push(longVal);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        long top = stack.pop();
        
        // 3. Compare top (long) with min (promoted to long)
        if (top < min) {
            // Restore previous min: 2 * min - top
            min = (int) (2L * min - top);
        }
    }

    public int top() {
        long top = stack.peek();
        // If top is encoded (less than min), the real top is min
        if (top < min) {
            return min;
        }
        return (int) top;
    }

    public int getMin() {
        return min;
    }
}