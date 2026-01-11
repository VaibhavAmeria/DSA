class Solution {
    public int MAH(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int area = 0;
        while (i < n) {
            if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
                st.push(i++);
            } else {
                int index = st.pop();

                if (st.isEmpty()) {
                    area = heights[index] * i;
                } else {
                    area = heights[index] * (i - st.peek() - 1);
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        while (!st.isEmpty()) {
            int index = st.pop();

            if (st.isEmpty()) {
                area = heights[index] * i;
            } else {
                area = heights[index] * (i - st.peek() - 1);
            }

            maxArea = Math.max(maxArea, area);
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
        // for (int col = 0; col < n; col++) {
        //     heights[col] = matrix[0][col] == '0' ? 0 : 1;
        // }
        
        // System.out.println("Initial heights: " + java.util.Arrays.toString(heights)); // [web:1]
        // int currentMAH = MAH(heights, n);
        // System.out.println("MAH after row 0: " + currentMAH + ", global maxArea: " + maxArea); // [web:1]
        // maxArea = Integer.MIN_VALUE;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col] += 1;
                }
            }
            
            System.out.println("Heights after row " + row + ": " + java.util.Arrays.toString(heights)); // [web:1]
            int currentMAH = MAH(heights, n);
            System.out.println("MAH after row " + row + ": " + currentMAH + ", global maxArea updated to: " + Math.max(maxArea, currentMAH)); // [web:1]
            maxArea = Math.max(maxArea, currentMAH);
        }

        System.out.println("Final maxArea: " + maxArea); // [web:1]
        return maxArea;
    }
}