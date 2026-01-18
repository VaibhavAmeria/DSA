class Solution {
    boolean check (int [][] squares, double mid_y, double total) {
        double bot_area = 0;
        for (int [] sq : squares) {
            double y = sq[1]; 
            double l = sq[2];
            double bottom_y = y;
            double top_y = y + l;
            
            if (mid_y >= top_y) {
                bot_area += l * l;
            }
            else if (mid_y > bottom_y) {
                bot_area += l * (mid_y - bottom_y);
            }
        }

        return bot_area >= (total / 2.0);
    }
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double total = 0.0;

        for (int [] sq : squares) {
            double x = sq[0];
            double y = sq[1];
            double l = sq[2];

            total += l*l;
            low = Math.min(low, y);        
            high = Math.max(high, y+l);
        }

        double resultY = 0.0;
        while (high - low > 1e-5) {
            double mid_y = low + (high - low) / 2.0;
            resultY = mid_y;

            if (check(squares, mid_y, total)) {
                // bottom area is more than half, move down
                high = mid_y;
            } else {
                low = mid_y;
            }
        }
        return resultY;
    }
}