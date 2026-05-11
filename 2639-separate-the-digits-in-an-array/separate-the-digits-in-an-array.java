class Solution {
    public int[] separateDigits(int[] nums) {
        List <Integer> ls = new ArrayList <>();

        for (int num : nums) {
            for (char ch : Integer.toString(num).toCharArray()) {
                ls.add(ch - '0');
            }
        }

        int [] res = new int [ls.size()];
        int index = 0;
        for (int num : ls) {
            res[index++] = num;
        }

        return res;
    }
}