class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer [] indices = new Integer [n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Stack <Integer> st = new Stack <>();
        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));
        List<Integer> result = new ArrayList<>();
        for (int currentIndex  : indices) {
            if (directions.charAt(currentIndex ) == 'R') {
                st.push(currentIndex);
            }
            else {
                while (!st.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = st.pop();
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        st.push(topIndex);
                    }
                    else if (healths[currentIndex] > healths[topIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    }
                    else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        return result;
    }
}