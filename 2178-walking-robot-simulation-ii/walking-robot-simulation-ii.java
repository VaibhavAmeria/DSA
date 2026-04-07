class Robot {
    List<int []> pos;
    boolean moved = false;
    int idx = 0;
    public Robot(int width, int height) {
        pos = new ArrayList <>();
        // East Moving
        for (int x = 0; x < width; x++) {
            pos.add(new int [] {x, 0, 0});
        }

        // North Moving
        for (int y = 1; y < height; y++) {
            pos.add(new int [] {width-1, y, 1});
        }

        // West Moving
        for (int x = width-2; x >= 0; x--) {
            pos.add(new int [] {x, height-1, 2});
        }

        // South Moving
        for (int y = height-2; y > 0; y--) {
            pos.add(new int [] {0, y, 3});
        }

        pos.get(0)[2] = 3;
    }
    
    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
    }
    
    public int[] getPos() {
        return new int [] {pos.get(idx)[0], pos.get(idx)[1]};   
    }
    
    public String getDir() {
        if (!moved) {
            return "East";
        }

       int d = pos.get(idx)[2];

        if (d == 0) return "East";
        else if (d == 1) return "North";
        else if (d == 2) return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */