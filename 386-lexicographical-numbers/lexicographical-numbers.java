class Solution {
    void solve (int startNumber, int n, List <Integer> res) {
        if (startNumber > n) {
            return;
        }
        res.add(startNumber);
        for (int append = 0; append <= 9; append++) {
            int newNumber = startNumber * 10 + append;
            if (newNumber > n) {
                return;
            }
            solve (newNumber, n, res);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList <>();
        for (int i = 1; i <= 9; i++) {
            solve (i, n, res);
        }
        return res;
    }
}