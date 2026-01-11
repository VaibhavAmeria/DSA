import java.util.*;
class Solution {
    public int MAH(int[] heights, int n) {
        int leftsmallerele[] = new int[heights.length];
        int rightsmallerele[] = new int[heights.length];
        Stack <Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftsmallerele[i] = -1;   
            }
            else {
                leftsmallerele[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for (int i = heights.length-1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightsmallerele[i] = heights.length;   
            }
            else {
                rightsmallerele[i] = st.peek();
            }
            st.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i]*(rightsmallerele[i]-leftsmallerele[i]-1));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col] += 1;
                }
            }
            
            System.out.println("Heights after row " + row + ": " + Arrays.toString(heights));
            int currentMAH = MAH(heights, n);
            System.out.println("MAH after row " + row + ": " + currentMAH + ", global maxArea updated to: " + Math.max(maxArea, currentMAH));
            maxArea = Math.max(maxArea, currentMAH);
        }

        System.out.println("Final maxArea: " + maxArea);
        return maxArea;
    }
}