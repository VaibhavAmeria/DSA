class Solution {
    public int minMaxDifference(int num) {
        String strNum = String.valueOf(num);
        StringBuilder maxBuilder = new StringBuilder(strNum);
        StringBuilder minBuilder = new StringBuilder(strNum);
        
        // Find first non-9 digit for max replacement
        char maxReplace = '9';
        for (char c : strNum.toCharArray()) {
            if (c != '9') {
                maxReplace = c;
                break;
            }
        }
        
        // Replace all occurrences of maxReplace with '9' for maximum number
        for (int i = 0; i < maxBuilder.length(); i++) {
            if (maxBuilder.charAt(i) == maxReplace) {
                maxBuilder.setCharAt(i, '9');
            }
        }

        System.out.println("maxBuilder -> " + maxBuilder.toString());
        
        // First digit for min replacement
        char minReplace = strNum.charAt(0);
        
        // Replace all occurrences of minReplace with '0' for minimum number
        for (int i = 0; i < minBuilder.length(); i++) {
            if (minBuilder.charAt(i) == minReplace) {
                minBuilder.setCharAt(i, '0');
            }
        }
        System.out.print("minBuilder -> " + minBuilder.toString());

        int maxNum = Integer.parseInt(maxBuilder.toString());
        int minNum = Integer.parseInt(minBuilder.toString());
        
        return maxNum - minNum;
    }
}